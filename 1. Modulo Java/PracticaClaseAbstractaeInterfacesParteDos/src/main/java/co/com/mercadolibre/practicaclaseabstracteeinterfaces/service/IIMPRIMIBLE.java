package co.com.mercadolibre.practicaclaseabstracteeinterfaces.service;

import co.com.mercadolibre.practicaclaseabstracteeinterfaces.pojos.Curriculum;
import co.com.mercadolibre.practicaclaseabstracteeinterfaces.pojos.Document;
import co.com.mercadolibre.practicaclaseabstracteeinterfaces.pojos.PdfBook;

public interface IIMPRIMIBLE {

    static void imprimir (Document document){

        if (document instanceof Curriculum) {
            System.out.println("The object to be printed is \n: "
            + document.toString());
        }else if (document instanceof PdfBook) {
            System.out.println("The object to be printed is \n: "
            + document.toString());
        }else {
            System.out.println("The object to be printed is \n: "
            + document.toString());
        }
    }
}
