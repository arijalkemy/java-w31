package co.com.mercadolibre.linkTracker.service;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import co.com.mercadolibre.linkTracker.dto.LinkDto;

import org.springframework.http.HttpHeaders;
import co.com.mercadolibre.linkTracker.exception.ConflictException;
import co.com.mercadolibre.linkTracker.exception.NotFoundException;
import co.com.mercadolibre.linkTracker.mapper.LinkMapper;
import co.com.mercadolibre.linkTracker.model.Link;
import co.com.mercadolibre.linkTracker.repository.LinkRepository;

@Service
public class LinkServiceImpl implements LinkService{

    private LinkRepository linkRepository;

    public LinkServiceImpl(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Override
    public LinkDto getById(Long id) {
        return linkRepository.getLinkById(id)
        .map(LinkMapper::LinkToLinkDto)
        .orElseThrow(() -> new NotFoundException("Object with the given id not found"));
    }

    @Override
    public LinkDto getMetricsById(Long id) {
        return this.getById(id);        
    }

    @Override
    public void invalidateLink(Long id, LinkDto linkDto) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public HttpHeaders redirect(Long id) {
        LinkDto linkDtoFound = this.getById(id);
        int increment = linkDtoFound.getRedirectCount()+1;
        Link link = new Link(linkDtoFound.getUrl(), linkDtoFound.getPassword(), true, increment);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(link.getUrl()));
        this.save(LinkMapper.LinkToLinkDto(link));
        return headers;
    }

    @Override
    public LinkDto save(LinkDto linkDto) throws RuntimeException {
        Optional<LinkDto> linkFlag = Optional.of(this.getById(linkDto.getId()));
        if (!linkFlag.isEmpty()) {
            throw new ConflictException("This Link already exists");
        }
        if (!this.isValidUrl(linkFlag.get().getUrl())) {
            throw new RuntimeException("We failed validating your URL entered");        
        }
        Link link = new Link(linkDto.getUrl(), 
        linkDto.getPassword(), 
        linkDto.isValid(), 
        linkDto.getRedirectCount());
        this.linkRepository.save(link);
        return new LinkDto(link.getId());
    }

    private boolean isValidUrl (String urlToBeValidate){
        try {
            new URI(urlToBeValidate).toURL();
            return true;
        } catch (MalformedURLException e) {
            return false;
        }catch(URISyntaxException e){
            return false;
        }
    }

    

    
}
