import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = CalculateService.class)
public class CalculateServiceTests {

    @Autowired
    private CalculateService calculateService;

    @Test
    public void calculateHousePriceTest() {
        //ARRANGE
        Integer price = 100;
        HouseDTO houseDTO = new HouseDTO("Polo Dot", "Posta xxxx", List.of(
                new RoomDTO("Room 1", 10, 20),
                new RoomDTO("Room 2", 20, 30)
        ));

        //ACT
        HouseResponseDTO houseResponseDTO = calculateService.calculate(houseDTO);

        //ASSERT
        Assertions.assertEquals(houseResponseDTO.getPrice(), (10*20 + 20*30)*800);
    }

    @Test
    public void calculateBiggestRoom() {
        //ARRANGE
        Integer price = 100;

        RoomDTO room1 = new RoomDTO("Room 1", 10, 20);
        RoomDTO room2 = new RoomDTO("Room 2", 20, 30);
        HouseDTO houseDTO = new HouseDTO("Polo Dot", "Posta xxxx", List.of(
                room1,
                room2
        ));

        //ACT
        HouseResponseDTO houseResponseDTO = calculateService.calculate(houseDTO);

        //ASSERT
        Assertions.assertEquals(houseResponseDTO.getBiggest(), room2);
    }

    @Test
    public void calculateSquareFeetPerRoom() {
        //ARRANGE
        Integer price = 100;

        RoomDTO room1 = new RoomDTO("Room 1", 10, 20);
        RoomDTO room2 = new RoomDTO("Room 2", 20, 30);
        HouseDTO houseDTO = new HouseDTO("Polo Dot", "Posta xxxx", List.of(
                room1,
                room2
        ));

        //ACT
        HouseResponseDTO houseResponseDTO = calculateService.calculate(houseDTO);

        //ASSERT
        Assertions.assertEquals(houseResponseDTO.getRooms().get(0).getSquareFeet(), room1.getLength()*room1.getWidth());
        Assertions.assertEquals(houseResponseDTO.getRooms().get(1).getSquareFeet(), room2.getLength()*room2.getWidth());
    }

}
