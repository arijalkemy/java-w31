import java.time.LocalDate;
import java.time.Period;

public class FechaService implements PersonaService{
    @Override
    public int calcularEdad(FechaDeNacimiento fechaDeNacimiento) {
        LocalDate nacimiento = fechaDeNacimiento.getFecha();

        return Period.between(nacimiento, LocalDate.now()).getYears();
    }
}
