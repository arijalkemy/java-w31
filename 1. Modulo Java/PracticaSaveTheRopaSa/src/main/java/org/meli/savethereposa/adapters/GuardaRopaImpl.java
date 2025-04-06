package org.meli.savethereposa.adapters;

import org.meli.savethereposa.domain.GuardaRopa;
import org.meli.savethereposa.domain.Prenda;
import org.meli.savethereposa.ports.IGuardable;
import org.meli.savethereposa.ports.IMostrable;
import org.meli.savethereposa.ports.IRetornable;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public class GuardaRopaImpl implements IGuardable, IMostrable, IRetornable {


    GuardaRopa ropa = new GuardaRopa();

    public GuardaRopaImpl(GuardaRopa ropa) {
        this.ropa = ropa;
    }

    //Investigar Type Erasure
    @Override
    public Integer guardarPrenda(List<Prenda> prendaList) {
        Integer claveDePrendaGuardada = new Random().nextInt(0, 10);
        ropa.getMapaDePrendas().put(claveDePrendaGuardada, prendaList);
        return claveDePrendaGuardada;
    }

    @Override
    public void mostrarPrendas() {
        ropa.getMapaDePrendas().forEach((key, prendasList) -> {
            System.out.println("Key: " + key);
            prendasList.forEach(prenda -> {
                System.out.println("Prenda: " + prenda);
            });
        });
    }

    @Override
    public List<Prenda> devolverPrendas(Integer numero) {
        return Optional.ofNullable(ropa.getMapaDePrendas().get(numero))
                .orElseGet(List::of);
    }
}
