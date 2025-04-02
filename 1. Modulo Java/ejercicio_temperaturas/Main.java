public class Main {
    public static void main(String[] args) {
        TemperaturasGlobales TG = new TemperaturasGlobales();
        int ciudadFria = TG.CiudadMasFria();
        int ciudadCalida = TG.CiudadMasCalida();
        System.out.println("La ciudad más fría es: " + TG.ciudades[ciudadFria] + " con una temperatura de: "
                + TG.temperaturas[ciudadFria][0]);
        System.out.println("La ciudad más cálida es: " + TG.ciudades[ciudadCalida] + " con una temperatura de: "
                + TG.temperaturas[ciudadCalida][1]);
    }
}
