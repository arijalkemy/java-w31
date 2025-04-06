package co.com.mercadolibre.practicaclaseabstracteeinterfaces;

import co.com.mercadolibre.practicaclaseabstracteeinterfaces.enums.Genres;
import co.com.mercadolibre.practicaclaseabstracteeinterfaces.enums.Skills;
import co.com.mercadolibre.practicaclaseabstracteeinterfaces.pojos.Curriculum;
import co.com.mercadolibre.practicaclaseabstracteeinterfaces.pojos.Document;
import co.com.mercadolibre.practicaclaseabstracteeinterfaces.pojos.PdfBook;
import co.com.mercadolibre.practicaclaseabstracteeinterfaces.pojos.Person;
import co.com.mercadolibre.practicaclaseabstracteeinterfaces.pojos.Report;
import co.com.mercadolibre.practicaclaseabstracteeinterfaces.service.IIMPRIMIBLE;

public class Main {
    public static void main(String[] args) {


        /*
         * Person to be printed along with the curriculum
         */
        Person person = new Person("1819283", "jhon doe", 12, 
        Skills.ATTENTION_TO_DETAIL, true);

        Document curriculum = new Curriculum(person);

        Document document = new PdfBook(370, Genres.ADVENTURE, "Robert C. Martin",
         "100 años de soledad");

        Document report = new Report(1000, 80, 
        "Jhon doe", "Jane Doe" );

        IIMPRIMIBLE.imprimir(curriculum);
        IIMPRIMIBLE.imprimir(document);
        IIMPRIMIBLE.imprimir(report);
    }
}