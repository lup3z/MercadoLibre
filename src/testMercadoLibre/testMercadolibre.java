package testMercadoLibre;
import java.util.concurrent.TimeUnit;
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
    	//Paso 1: instancio el navegador:
        //lo llamo para utilizarlo y le hago las configuraciones necesarias
        ChromeOptions opts =new ChromeOptions();
    	opts.addArguments("--start-maximized");
        driver = new ChromeDriver(opts);
        //aplico el uso en una URL especifica
        driver.get("http://mercadolibre.com/");
        //ingreso a la opcion de argentina de ML
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
        /////SEGUNDO ESCENARIO Tecnología - Celulares y Smartphones////
        ///////////////////////////////////////////////////////////////

        WebElement categoria2 = driver.findElement(By.xpath("//*[@class='nav-menu-item']//*[text()='Categorías']"));
        categoria2.click();
        WebElement categoriaTecnologia = driver.findElement(By.xpath("//a[@href='#' and contains (.,'Tecnología')]"));
        categoriaTecnologia.click();  
        WebElement celusYSmarts = driver.findElement(By.xpath("//*[@class='nav-categs-detail__categ-list']//a[text()='Celulares y Smartphones']"));
        celusYSmarts.click();

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
        categoria.click();
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
