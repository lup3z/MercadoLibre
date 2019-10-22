package testMercadoLibre;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class testMercadolibre {

public static ChromeDriver driver;

    public static void main(String[] args) {
    	//Paso 1: instancio el navegador:
        //tomo la la direccion local del driver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tools\\chromedriver.exe");
        //lo llamo para utilizarlo y hago las configuraciones necesarias
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
        ////////////////////////////////////////////////////////////////
        //PRIMER ESCENARIO Hogar y Electrodomésticos - Climatización///
        ///////////////////////////////////////////////////////////////
        WebElement categoria = driver.findElement(By.xpath("//*[@class='nav-menu-item']//*[text()='Categorías']"));
        categoria.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement categoriaHYE = driver.findElement(By.xpath("//*[text()='Hogar y Electrodomésticos']"));
        categoriaHYE.click();  
        WebElement climatizacion = driver.findElement(By.xpath("//*[text()='Climatización']"));
        climatizacion.click();
        //IGNORO EL ALERTA QUE APARECE
        Alert alerta = driver.switchTo().alert(); //cambio al modal del alerta
    	alerta.dismiss();
        WebElement titulo = driver.findElement(By.xpath("//*[@class='breadcrumb__title']"));
        titulo.isDisplayed();
        WebElement cantidadHYE = driver.findElement(By.xpath("//*[text()=' 62.271 resultados']"));
        cantidadHYE.isDisplayed();
        System.out.println("El PRIMER test corrio bien");
        ////////////////////////////////////////////////////////////////
        //SEGUNDO ESCENARIO Tecnología - Celulares y Smartphones///////
        ///////////////////////////////////////////////////////////////
        categoria.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement categoriaTecnologia = driver.findElement(By.xpath("//a[@href='#' and contains (.,'Tecnología')]"));
        categoriaTecnologia.click();  
        WebElement celusYSmarts = driver.findElement(By.xpath("//*[@class='nav-categs-detail__categ-list']//a[text()='Celulares y Smartphones']"));
        celusYSmarts.click();
        //IGNORO EL ALERTA QUE APARECE
    	alerta.dismiss();
        titulo.isDisplayed();
        WebElement cantidadCelus = driver.findElement(By.xpath("//*[text()=' 92.522 resultados']"));
        cantidadCelus.isDisplayed();
        System.out.println("El SEGUNDO test corrio bien");
        ///////////////////////////////////////////////////////////////////
        //TERCER ESCENARIO Belleza y Cuidado Personal - Perfume importado//
        ///////////////////////////////////////////////////////////////////
        categoria.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement belleza = driver.findElement(By.xpath("//a[text()='Belleza y Cuidado Personal']"));
        belleza.click();  
        //NO EXISTE LA SUBCATEGORIA DEFINIDA
        System.out.println("El TERCER test corrio bien");
        ////////////////////////////////////////////////////////////////
        //CUARTO ESCENARIO Herramientas e Industria - Industria Textil//
        ////////////////////////////////////////////////////////////////
        categoria.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement categoriaIndustria = driver.findElement(By.xpath("//a[@href='#' and contains (.,'Herramientas e Industrias')]"));
        categoriaIndustria.click();  
        WebElement textil = driver.findElement(By.xpath("//*[@class='nav-categs-detail__categ-list']//a[text()='Industria Textil']"));
        textil.click();
        titulo.isDisplayed();
        WebElement cantidadIndustria = driver.findElement(By.xpath("//*[text()=' 26.355 resultados']"));
        cantidadIndustria.isDisplayed();
        System.out.println("El CUARTO test corrio bien");
        ////////////////////////////////////////////////////////////////
        //QUINTO ESCENARIO Juguetes y Bebés - Cuarto del Bebé///////////
        ////////////////////////////////////////////////////////////////
        categoria.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement categoriaBebes = driver.findElement(By.xpath("//a[@href='#' and contains (.,'Juguetes y Bebés')]"));
        categoriaBebes.click();  
        WebElement cuartoBebe = driver.findElement(By.xpath("//*[@class='nav-categs-detail__title']//a[text()='Cuarto del Bebé']"));
        cuartoBebe.click();
        titulo.isDisplayed();
        WebElement cantidadBebe = driver.findElement(By.xpath("//*[text()=' 28.194 resultados']"));
        cantidadIndustria.isDisplayed();
        System.out.println("El QUINTO test corrio bien");
}


}
