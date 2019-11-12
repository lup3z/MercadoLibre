package testMercadoLibre;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import com.sun.deploy.security.SelectableSecurityManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class testMercadolibre {

public static ChromeDriver driver;

    public static void main(String[] args) {
        String value=" ";
    	//Paso 1: instancio el navegador:
        //lo llamo para utilizarlo y le hago las configuraciones necesarias
        ChromeOptions opts =new ChromeOptions();
    	//opts.addArguments("--start-maximized");
        driver = new ChromeDriver(opts);
        //aplico el uso en una URL especifica
        driver.get("http://mercadolibre.com/");
        //selecciono a la opcion de argentina de ML
        WebElement searchButton = driver.findElement(By.id("AR"));
        searchButton.click();
        //aplico un wait implicito
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait( driver, 5);

        ////////////////////////////////////////////////////////////////
        //PRIMER ESCENARIO Hogar y Electrodomésticos - Climatización///
        ///////////////////////////////////////////////////////////////

        WebElement categoria = driver.findElement(By.xpath("//*[@class='nav-menu-item']//*[text()='Categorías']"));
        categoria.click();

        //APLICO UNA ESPERA HASTA QUE APAREZCA EL ELEMENTO
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href, 'menu=categories') ]")));
        WebElement categoriaHYE = driver.findElement(By.xpath("//*[text()='Hogar y Electrodomésticos']"));
        categoriaHYE.click();
        WebElement climatizacion = driver.findElement(By.xpath("//*[text()='Climatización']"));
        climatizacion.click();

        //IGNORO EL ALERTA QUE APARECE
        WebElement modal = driver.findElement(By.xpath("//*[@class='onboarding-cp-button andes-button andes-button--filled andes-button--small']"));
        modal.click();

        //VALIDO CONTENIDO SOLICITADO
        WebElement titulo = driver.findElement(By.xpath("//*[@class='breadcrumb__title']"));
        titulo.isDisplayed();
        WebElement cantidadHYE = driver.findElement(By.xpath("//*[@class='quantity-results']"));
        cantidadHYE.isDisplayed();
        System.out.println("El PRIMER test corrio bien");

        ////////////////////////////////////////////////////////////////
        ////////////////////// EJERCIO 2 //////////////////////////////
        ///////////////////////////////////////////////////////////////

        WebElement caba = driver.findElement(By.xpath("//a[@title='Capital Federal']//*[@class='filter-name']"));
        caba.click();
        List<WebElement> listaResultados = driver.findElements(By.xpath("//div[contains(@class, 'rowItem')]"));

        // obtener la info de un producto al azar
        int numElementos = listaResultados.size();
        int randomElementNumber = new Random().nextInt(numElementos);
        WebElement elegido = listaResultados.get(randomElementNumber);
        WebElement nombreProductoElegido = elegido.findElement(By.cssSelector("span.main-title"));
        String nombreProducto = nombreProductoElegido.getText();

        WebElement precioProductoElegido = elegido.findElement(By.cssSelector("span.price__fraction"));
        String precioProducto = precioProductoElegido.getText();

        //darle click al elemento al azar
        nombreProductoElegido.click();
        //verificar la informacion

        //sacar el nombre del producto
        WebElement productoseleccionado = driver.findElement(By.cssSelector("h1.item-title__primary"));
        productoseleccionado.getText();
        String actualName=productoseleccionado.getText();

        WebElement precioseleccionado = driver.findElement(By.xpath("//*[@id='productInfo']//*[@class='price-tag']//*[@class='price-tag-fraction']"));
        precioseleccionado.getText();
        String actualPrecio=precioseleccionado.getText();

        //ELIJO PRODUCTO VALIDO TITULO Y PRECIO
        if (actualName.equals(nombreProducto))
            System.out.println("Es el mismo nombre");
        if (actualPrecio.equals(precioProducto))
            System.out.println("Es el mismo precio");

        ////////////////////////////////////////////////////////////////
        /////SEGUNDO ESCENARIO Tecnología - Celulares y Smartphones////
        ///////////////////////////////////////////////////////////////

        WebElement categoria2 = driver.findElement(By.xpath("//*[@class='nav-menu-item']//*[text()='Categorías']"));
        categoria2.click();
        WebElement categoriaTecnologia = driver.findElement(By.xpath("//a[@href='#' and contains (.,'Tecnología')]"));
        categoriaTecnologia.click();  
        WebElement celusYSmarts = driver.findElement(By.xpath("//*[@class='nav-categs-detail__categ-list']//a[text()='Celulares y Smartphones']"));
        celusYSmarts.click();
        //CAMBIO LA VISTA DE LA GRILLA

        WebElement grilla = driver.findElement(By.xpath("//*[@class='ico view-option-grid']"));
        grilla.click();

        //CUENTO LOS ITEMS QUE HAY DENTRO DEL CONTENEDOR DE RESULTADOS
        int xpathCountPRODUCTO = driver.findElements(By.xpath("//*[@class='item__bookmark-form']")).size();
        System.out.println("LA CANTIDAD DE ITEMS CELULARES ES:"+ xpathCountPRODUCTO);

        //SE VALIDA EL CONTENIDO SOLICITADO
        WebElement tituloTecnologia = driver.findElement(By.xpath("//*[@class='breadcrumb__title']"));
        tituloTecnologia.isDisplayed();
        WebElement cantidadCelus = driver.findElement(By.xpath("//*[@class='quantity-results']"));
        cantidadCelus.isDisplayed();
        System.out.println("El SEGUNDO test corrio bien");

        ///////////////////////////////////////////////////////////////////
        //TERCER ESCENARIO Belleza y Cuidado Personal - Perfume importado//
        ///////////////////////////////////////////////////////////////////

        WebElement categoria3 = driver.findElement(By.xpath("//*[@class='nav-menu-item']//*[text()='Categorías']"));
        categoria3.click();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement belleza = driver.findElement(By.xpath("//a[text()='Belleza y Cuidado Personal']"));
        belleza.click();  
        //NO EXISTE LA SUBCATEGORIA DEFINIDA
        System.out.println("El TERCER test corrio bien");

        ////////////////////////////////////////////////////////////////
        //CUARTO ESCENARIO Herramientas e Industria - Industria Textil//
        ////////////////////////////////////////////////////////////////

        WebElement categoria4 = driver.findElement(By.xpath("//*[@class='nav-menu-item']//*[text()='Categorías']"));
        categoria4.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement categoriaIndustria = driver.findElement(By.xpath("//a[@href='#' and contains (.,'Herramientas e Industrias')]"));
        categoriaIndustria.click();  
        WebElement textil = driver.findElement(By.xpath("//*[@class='nav-categs-detail__categ-list']//a[text()='Industria Textil']"));
        textil.click();

        //SE ORDENA POR MAYOR PRECIO, Y SE IMPRIME EL PRIMER Y ULTIMO PRECIO
        WebElement dropdown = driver.findElement(By.xpath("//*[@class='view-options']//*[@class='ui-dropdown__link']"));
        dropdown.isDisplayed();
        dropdown.click();
        WebElement mayorprecio = driver.findElement(By.xpath("//*[@class='ui-list__item-option' and contains (.,' Mayor precio ')]"));
        mayorprecio.isDisplayed();
        mayorprecio.click();
        List<WebElement> listadePRECIOS = driver.findElements(By.xpath("//*[@class='price__fraction']"));
        String mayorPRECIO=listadePRECIOS.get(0).getText();
        String menorPRECIO=listadePRECIOS.get(listadePRECIOS.size() -1).getText();
        System.out.println("El MAYOR PRECIO ES:" + mayorPRECIO);
        System.out.println("El MENOR PRECIO ES:"+ menorPRECIO);

        //SE VALIDA EL CONTENIDO SOLICITADO
        WebElement tituloHerramientas = driver.findElement(By.xpath("//*[@class='breadcrumb__title']"));
        tituloHerramientas.isDisplayed();
        WebElement cantidadIndustria = driver.findElement(By.xpath("//*[@class='quantity-results']"));
        cantidadIndustria.isDisplayed();
        System.out.println("El CUARTO test corrio bien");

        ////////////////////////////////////////////////////////////////
        //QUINTO ESCENARIO Juguetes y Bebés - Cuarto del Bebé///////////
        ////////////////////////////////////////////////////////////////

        WebElement categoria5 = driver.findElement(By.xpath("//*[@class='nav-menu-item']//*[text()='Categorías']"));
        categoria5.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement categoriaBebes = driver.findElement(By.xpath("//a[@href='#' and contains (.,'Juguetes y Bebés')]"));
        categoriaBebes.click();  
        WebElement cuartoBebe = driver.findElement(By.xpath("//*[@class='nav-categs-detail__title']//a[text()='Cuarto del Bebé']"));
        cuartoBebe.click();

        //SELECCIONAR LA OPCION “Llegan mañana”
        WebElement llegaMAÑANA = driver.findElement(By.xpath("//*[@class='spotlight__switch-bar spotlight__switch--off']"));
        llegaMAÑANA.isDisplayed();
        llegaMAÑANA.click();
        List<WebElement> busquedatexto = driver.findElements(By.xpath("//*[@class='next_day']"));
        WebElement llegaMAÑANADISPLAYED = driver.findElement(By.xpath("//*[@class='spotlight__switch-bar spotlight__switch--on']"));
        llegaMAÑANADISPLAYED.isDisplayed();

        // VERIFICAR LOS PRIMEROS 5, “Llega mañana” O “Llega gratis mañana”
        int i= 0;
            for(WebElement w:busquedatexto) {
                String str = w.getText();
                driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                if (i < 5)
                        if (w.getText().equalsIgnoreCase("Llega gratis mañana")||w.getText().equalsIgnoreCase("Llega mañana")){
                            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                            System.out.println("ok");
                            i++; }
                        else{System.out.println("error");
                            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                            i++;}
            }

        //SE VALIDA EL CONTENIDO SOLICITADO
        WebElement tituloJuguetes = driver.findElement(By.xpath("//*[@class='breadcrumb__title']"));
        tituloJuguetes.isDisplayed();
        WebElement cantidadBebe = driver.findElement(By.xpath("//*[@class='quantity-results']"));
        cantidadBebe.isDisplayed();
        System.out.println("El QUINTO test corrio bien");

        //CERRAR EL NAVEGADOR
        driver.close();
}


}
