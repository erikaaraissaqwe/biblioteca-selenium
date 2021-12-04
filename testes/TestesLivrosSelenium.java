import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestesLivrosSelenium {
    public static WebDriver driver;
    private static final String userPath = System.getProperty("user.dir");
    private static final String urlInicial = "https://erikaaraissaqwe.github.io/biblioteca-front/pages/index.html";

    @BeforeAll
    public static void setup(){

        System.setProperty("webdriver.chrome.driver",
                userPath + "\\lib\\chrome\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(urlInicial);
    }

    @AfterAll
    public static void end(){
        driver.quit();
    }

    //Verificar se todos os links estão sendo redirecionados para as páginas corretas;

    //Links da Pagina de Livros

    //Teste com o título de página
    @Test
    @Order(1)
    public void titlePageLivrosTest() throws InterruptedException {
        driver.get(urlInicial);
        driver.findElement(By.id("gerenciaLivros")).click();
        String titulo = driver.getTitle();
        Thread.sleep(2000);
        assertEquals("Livros", titulo);
    }

    //Teste com a url da página
    @Test
    @Order(2)
    public void urlPageLivrosTest() throws InterruptedException {
        driver.get(urlInicial);
        String urlEsperada = "https://erikaaraissaqwe.github.io/biblioteca-front/pages/livros/gerenciaLivro.html";
        driver.findElement(By.id("gerenciaLivros")).click();
        String urlAtual = driver.getCurrentUrl();
        Thread.sleep(2000);
        assertEquals(urlEsperada, urlAtual);
    }

    //Teste com o título de página
    @Test
    @Order(3)
    public void titlePageDetalhesTest() throws InterruptedException {
        driver.get("https://erikaaraissaqwe.github.io/biblioteca-front/pages/livros/gerenciaLivro.html");
        driver.findElement(By.cssSelector("#tabela_livros > tbody > tr:nth-child(1) > " +
                "td:nth-child(2) > div > " +
                "a:nth-child(1)")).click();
        String titulo = driver.getTitle();
        Thread.sleep(2000);
        assertEquals("Detalhes", titulo);
    }

    //Teste com a url da página
    @Test
    @Order(4)
    public void urlPageLivrosDetalhesTest() throws InterruptedException {
        driver.get("https://erikaaraissaqwe.github.io/biblioteca-front/pages/livros/gerenciaLivro.html");
        String urlEsperada = "https://erikaaraissaqwe.github.io/biblioteca-front/pages/livros/detalhesLivro.html";
        driver.findElement(By.cssSelector("#tabela_livros > tbody > tr:nth-child(1) > " +
                "td:nth-child(2) > div > " +
                "a:nth-child(1)")).click();
        String urlAtual = driver.getCurrentUrl();
        Thread.sleep(2000);
        assertEquals(urlEsperada, urlAtual);
    }

    //Teste com o título de página
    @Test
    @Order(5)
    public void titlePageDetalhesVoltarTest() throws InterruptedException {
        driver.get("https://erikaaraissaqwe.github.io/biblioteca-front/pages/livros/detalhesLivro.html");
        driver.findElement(By.id("back")).click();
        String titulo = driver.getTitle();
        Thread.sleep(2000);
        assertEquals("Livros", titulo);
    }

    //Teste com a url da página
    @Test
    @Order(6)
    public void urlPageDetalhesVoltarTest() throws InterruptedException {
        driver.get("https://erikaaraissaqwe.github.io/biblioteca-front/pages/livros/detalhesLivro.html");
        String urlEsperada = "https://erikaaraissaqwe.github.io/biblioteca-front/pages/livros/gerenciaLivro.html";
        Thread.sleep(2000);
        driver.findElement(By.id("back")).click();
        String urlAtual = driver.getCurrentUrl();
        Thread.sleep(2000);
        assertEquals(urlEsperada, urlAtual);
    }


    //Teste com o título de página
    @Test
    @Order(7)
    public void titlePageEditarTest() throws InterruptedException {
        driver.get("https://erikaaraissaqwe.github.io/biblioteca-front/pages/livros/gerenciaLivro.html");
        driver.findElement(By.cssSelector("#tabela_livros > tbody > tr:nth-child(1) > " +
                "td:nth-child(2) > div > a:nth-child(3)")).click();
        String titulo = driver.getTitle();
        Thread.sleep(2000);
        assertEquals("Edição de Livros", titulo);
    }

    //Teste com a url da página
    @Test
    @Order(8)
    public void urlPageEditarTest() throws InterruptedException {
        driver.get("https://erikaaraissaqwe.github.io/biblioteca-front/pages/livros/gerenciaLivro.html");
        String urlEsperada = "https://erikaaraissaqwe.github.io/biblioteca-front/pages/livros/editarLivro.html";
        driver.findElement(By.cssSelector("#tabela_livros > tbody > tr:nth-child(1) > " +
                "td:nth-child(2) > div > a:nth-child(3)")).click();
        String urlAtual= driver.getCurrentUrl();
        Thread.sleep(2000);
        assertEquals(urlEsperada, urlAtual);
    }

    //Teste com o título de página
    @Test
    @Order(9)
    public void titlePageEditarCancelarTest() throws InterruptedException {
        driver.get("https://erikaaraissaqwe.github.io/biblioteca-front/pages/livros/editarLivro.html");
        driver.findElement(By.id("back")).click();
        String titulo = driver.getTitle();
        Thread.sleep(2000);
        assertEquals("Livros", titulo);
    }

    //Teste com a url da página
    @Test
    @Order(10)
    public void urlPageEditarCancelarTest() throws InterruptedException {
        driver.get("https://erikaaraissaqwe.github.io/biblioteca-front/pages/livros/editarLivro.html");
        String urlEsperada = "https://erikaaraissaqwe.github.io/biblioteca-front/pages/livros/gerenciaLivro.html";
        driver.findElement(By.id("back")).click();
        String urlAtual= driver.getCurrentUrl();
        Thread.sleep(2000);
        assertEquals(urlEsperada, urlAtual);
    }

    //Teste com o título de página
    @Test
    @Order(11)
    public void titlePageEditarSalvarTest() throws InterruptedException {
        driver.get("https://erikaaraissaqwe.github.io/biblioteca-front/pages/livros/editarLivro.html");
        driver.findElement(By.id("save")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        String titulo = driver.getTitle();
        assertEquals("Livros", titulo);
    }

    //Teste com a url da página
    @Test
    @Order(12)
    public void urlPageEditarSalvarTest() throws InterruptedException {
        driver.get("https://erikaaraissaqwe.github.io/biblioteca-front/pages/livros/editarLivro.html");
        String urlEsperada = "https://erikaaraissaqwe.github.io/biblioteca-front/pages/livros/gerenciaLivro.html";
        driver.findElement(By.id("save")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        String urlAtual= driver.getCurrentUrl();
        Thread.sleep(2000);
        assertEquals(urlEsperada, urlAtual);
    }

    //Teste com o Alert
    @Test
    @Order(13)
    public void urlPageDeleteConfirmTest() throws InterruptedException {
        driver.get("https://erikaaraissaqwe.github.io/biblioteca-front/pages/livros/gerenciaLivro.html");
        String textEsperado = "Livro Salock, o maligno removido!";
        driver.findElement(By.cssSelector("#tabela_livros > tbody > tr:nth-child(1) > " +
                "td:nth-child(2) > div > a:nth-child(2)")).click();
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        String text = driver.switchTo().alert().getText();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        assertEquals(textEsperado, text);
    }

    //Teste com o Alert
    @Test
    @Order(14)
    public void urlPageDeleteCancelTest() throws InterruptedException {
        driver.get("https://erikaaraissaqwe.github.io/biblioteca-front/pages/livros/gerenciaLivro.html");
        String textEsperado = "Livro Salock, o maligno não foi removido!";
        driver.findElement(By.cssSelector("#tabela_livros > tbody > tr:nth-child(1) > " +
                "td:nth-child(2) > div > a:nth-child(2)")).click();
        driver.switchTo().alert().dismiss();
        Thread.sleep(2000);
        String text = driver.switchTo().alert().getText();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        assertEquals(textEsperado, text);
    }

    //Teste com o título de página
    @Test
    @Order(15)
    public void titlePageCadastrarTest() throws InterruptedException {
        driver.get("https://erikaaraissaqwe.github.io/biblioteca-front/pages/livros/gerenciaLivro.html");
        driver.findElement(By.cssSelector("#form > a")).click();
        String titulo = driver.getTitle();
        Thread.sleep(2000);
        assertEquals("Cadastrar Livros", titulo);
    }

    //Teste com a url da página
    @Test
    @Order(16)
    public void urlPageCadastrarTest() throws InterruptedException {
        driver.get("https://erikaaraissaqwe.github.io/biblioteca-front/pages/livros/gerenciaLivro.html");
        String urlEsperada = "https://erikaaraissaqwe.github.io/biblioteca-front/pages/livros/cadastrarLivro.html";
        driver.findElement(By.cssSelector("#form > a")).click();
        String urlAtual = driver.getCurrentUrl();
        Thread.sleep(2000);
        assertEquals(urlEsperada, urlAtual);
    }

    //Teste com o título de página
    @Test
    @Order(17)
    public void titlePageCadastrarCancelarTest() throws InterruptedException {
        driver.get("https://erikaaraissaqwe.github.io/biblioteca-front/pages/livros/cadastrarLivro.html");
        driver.findElement(By.id("back")).click();
        String titulo = driver.getTitle();
        Thread.sleep(2000);
        assertEquals("Livros", titulo);
    }

    //Teste com a url da página
    @Test
    @Order(18)
    public void urlPageCadastrarCancelarTest() throws InterruptedException {
        driver.get("https://erikaaraissaqwe.github.io/biblioteca-front/pages/livros/cadastrarLivro.html");
        String urlEsperada = "https://erikaaraissaqwe.github.io/biblioteca-front/pages/livros/gerenciaLivro.html";
        driver.findElement(By.id("back")).click();
        String urlAtual= driver.getCurrentUrl();
        Thread.sleep(2000);
        assertEquals(urlEsperada, urlAtual);
    }

    //Teste salvar
    @Test
    @Order(19)
    public void titlePageCadastarSalvarTest() throws InterruptedException {
        driver.get("https://erikaaraissaqwe.github.io/biblioteca-front/pages/livros/cadastrarLivro.html");
        WebElement tituloBook = driver.findElement(By.id("titulo"));
        WebElement autores = driver.findElement(By.className("autores"));
        WebElement isbn = driver.findElement(By.id("isbn"));
        WebElement genero = driver.findElement(By.id("genero"));
        WebElement numeroPaginas = driver.findElement(By.id("nPaginas"));

        tituloBook.sendKeys("Contos de um mundo aleatorio");
        isbn.sendKeys("123456EP");
        genero.sendKeys("Fantasia");
        autores.sendKeys("Erika Raissa Bueno da Silva");
        numeroPaginas.sendKeys("512");
        Thread.sleep(2000);

        driver.findElement(By.id("save")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        String titulo = driver.getTitle();
        assertEquals("Livros", titulo);
    }

    //Teste com a url da página
    @Test
    @Order(20)
    public void urlPageCadastarSalvarTest() throws InterruptedException {
        driver.get("https://erikaaraissaqwe.github.io/biblioteca-front/pages/livros/cadastrarLivro.html");
        WebElement tituloBook = driver.findElement(By.id("titulo"));
        WebElement autores = driver.findElement(By.className("autores"));
        WebElement isbn = driver.findElement(By.id("isbn"));
        WebElement genero = driver.findElement(By.id("genero"));
        WebElement numeroPaginas = driver.findElement(By.id("nPaginas"));

        tituloBook.sendKeys("Contos de um mundo aleatorio");
        isbn.sendKeys("123456EP");
        genero.sendKeys("Fantasia");
        autores.sendKeys("Erika Raissa Bueno da Silva");
        numeroPaginas.sendKeys("512");
        Thread.sleep(2000);

        String urlEsperada = "https://erikaaraissaqwe.github.io/biblioteca-front/pages/livros/gerenciaLivro.html";
        driver.findElement(By.id("save")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        String urlAtual= driver.getCurrentUrl();
        Thread.sleep(2000);
        assertEquals(urlEsperada, urlAtual);
    }

    //Teste com o título de página
    @Test
    @Order(21)
    public void titlePageListarSalvarTest() throws InterruptedException {
        driver.get("https://erikaaraissaqwe.github.io/biblioteca-front/pages/livros/cadastrarLivro.html");
        driver.findElement(By.cssSelector("#list > a")).click();
        Thread.sleep(2000);
        String titulo = driver.getTitle();
        assertEquals("Livros", titulo);
    }

    //Teste com a url da página
    @Test
    @Order(22)
    public void urlPageListarTest() throws InterruptedException {
        driver.get("https://erikaaraissaqwe.github.io/biblioteca-front/pages/livros/cadastrarLivro.html");
        String urlEsperada = "https://erikaaraissaqwe.github.io/biblioteca-front/pages/livros/gerenciaLivro.html";
        driver.findElement(By.cssSelector("#list > a")).click();
        String urlAtual= driver.getCurrentUrl();
        Thread.sleep(2000);
        assertEquals(urlEsperada, urlAtual);
    }

    //Teste com o título de página
    @Test
    @Order(23)
    public void titlePageInicialTest() throws InterruptedException {
        driver.get("https://erikaaraissaqwe.github.io/biblioteca-front/pages/livros/gerenciaLivro.html");
        driver.findElement(By.cssSelector("#home > a")).click();
        Thread.sleep(2000);
        String titulo = driver.getTitle();
        assertEquals("Biblioteca", titulo);
    }

    //Teste com a url da página
    @Test
    @Order(24)
    public void urlPageInicialTest() throws InterruptedException {
        driver.get("https://erikaaraissaqwe.github.io/biblioteca-front/pages/livros/gerenciaLivro.html");
        String urlEsperada = "https://erikaaraissaqwe.github.io/biblioteca-front/pages/index.html";
        driver.findElement(By.cssSelector("#home > a")).click();
        String urlAtual= driver.getCurrentUrl();
        Thread.sleep(2000);
        assertEquals(urlEsperada, urlAtual);
    }

    //Teste com form de cadastro
    @Test
    @Order(25)
    public void formPageCadastroTest() throws InterruptedException {
        driver.get("https://erikaaraissaqwe.github.io/biblioteca-front/pages/livros/cadastrarLivro.html");

        WebElement tituloBook = driver.findElement(By.id("titulo"));
        WebElement autores = driver.findElement(By.className("autores"));
        WebElement isbn = driver.findElement(By.id("isbn"));
        WebElement genero = driver.findElement(By.id("genero"));
        WebElement numeroPaginas = driver.findElement(By.id("nPaginas"));

        tituloBook.sendKeys("Contos de um mundo aleatorio");
        isbn.sendKeys("123456EP");
        genero.sendKeys("Fantasia");
        autores.sendKeys("Erika Raissa Bueno da Silva");
        numeroPaginas.sendKeys("512");
        Thread.sleep(2000);

        assertAll(
                () -> assertTrue(tituloBook.isDisplayed()),
                () -> assertEquals("Contos de um mundo aleatorio", tituloBook.getAttribute("value")),
                () -> assertTrue(autores.isDisplayed()),
                () -> assertEquals("Erika Raissa Bueno da Silva", autores.getAttribute("value")),
                () -> assertTrue(isbn.isDisplayed()),
                () -> assertEquals("123456EP", isbn.getAttribute("value")),
                () -> assertTrue(genero.isDisplayed()),
                () -> assertEquals("Fantasia", genero.getAttribute("value")),
                () -> assertTrue(numeroPaginas.isDisplayed()),
                () -> assertEquals("512", numeroPaginas.getAttribute("value"))
        );
    }

    //Teste com form de edição
    @Test
    @Order(26)
    public void formPageEditarTest() throws InterruptedException {
        driver.get("https://erikaaraissaqwe.github.io/biblioteca-front/pages/livros/gerenciaLivro.html");
        driver.findElement(By.cssSelector("#tabela_livros > tbody > tr:nth-child(1) > td:nth-child(2) > div > a:nth-child(3)")).click();
        Thread.sleep(3000);

        WebElement tituloBook = driver.findElement(By.id("titulo"));
        List<WebElement> autores = driver.findElements(By.className("autores"));
        WebElement isbn = driver.findElement(By.id("isbn"));
        WebElement genero = driver.findElement(By.id("genero"));
        WebElement numeroPaginas = driver.findElement(By.id("nPaginas"));

        Thread.sleep(2000);

        assertAll(
                () -> assertTrue(tituloBook.isDisplayed()),
                () -> assertEquals("Salock, o maligno", tituloBook.getAttribute("value")),
                () -> assertTrue(autores.get(0).isDisplayed()),
                () -> assertEquals("Robson Matos", autores.get(0).getAttribute("value")),
                () -> assertTrue(autores.get(1).isDisplayed()),
                () -> assertEquals("Matias Roberson", autores.get(1).getAttribute("value")),
                () -> assertTrue(isbn.isDisplayed()),
                () -> assertEquals("40028922", isbn.getAttribute("value")),
                () -> assertTrue(genero.isDisplayed()),
                () -> assertEquals("Fantasia", genero.getAttribute("value")),
                () -> assertTrue(numeroPaginas.isDisplayed()),
                () -> assertEquals("500", numeroPaginas.getAttribute("value"))
        );
    }

     //Teste com form de cadastro inválido
    @Test
    @Order(27)
    public void formPageCadastroInvalidTest() throws InterruptedException {
        driver.get("https://erikaaraissaqwe.github.io/biblioteca-front/pages/livros/cadastrarLivro.html");

        driver.findElement(By.id("save")).click();

        Thread.sleep(3000);

        String requerid = "Este campo é requerido.";

        WebElement reqTitulo = driver.findElement(By.id("reqTitulo"));
        WebElement reqIsbn = driver.findElement(By.id("reqIsbn"));
        WebElement reqGenero = driver.findElement(By.id("reqGen"));
        WebElement reqPag = driver.findElement(By.id("reqPag"));
        WebElement reqAutores = driver.findElement(By.id("reqAutores"));


        Thread.sleep(2000);

        assertAll(
                () -> assertTrue(reqTitulo.isDisplayed()),
                () -> assertEquals(requerid, reqTitulo.getText()),
                () -> assertTrue(reqIsbn.isDisplayed()),
                () -> assertEquals(requerid, reqIsbn.getText()),
                () -> assertTrue(reqGenero.isDisplayed()),
                () -> assertEquals(requerid, reqGenero.getText()),
                () -> assertTrue(reqPag.isDisplayed()),
                () -> assertEquals(requerid, reqPag.getText()),
                () -> assertTrue(reqAutores.isDisplayed()),
                () -> assertEquals(requerid, reqAutores.getText())
        );
    }

     //Teste com Forward
    @Test
    @Order(28)
    public void formPageBack() throws InterruptedException {

        driver.get("https://erikaaraissaqwe.github.io/biblioteca-front/pages/livros/gerenciaLivro.html");
        driver.findElement(By.cssSelector("#tabela_livros > tbody > tr:nth-child(1) > td:nth-child(2) > div > a:nth-child(3)")).click();

        driver.navigate().back();

        Thread.sleep(2000);

        String urlAtual= driver.getCurrentUrl();

        assertEquals("https://erikaaraissaqwe.github.io/biblioteca-front/pages/livros/gerenciaLivro.html", urlAtual);

    }

//    //Teste com Forward
    @Test
    @Order(30)
    public void formPageForward() throws InterruptedException {

        driver.get("https://erikaaraissaqwe.github.io/biblioteca-front/pages/livros/gerenciaLivro.html");
        driver.findElement(By.cssSelector("#home > a")).click();

        driver.navigate().back();
        driver.navigate().forward();

        Thread.sleep(2000);

        String urlAtual= driver.getCurrentUrl();

        assertEquals("https://erikaaraissaqwe.github.io/biblioteca-front/pages/index.html", urlAtual);

    }

//    //Teste com Nagivate
    @Test
    @Order(31)
    public void formPageNagivate() throws InterruptedException {

        driver.get("https://erikaaraissaqwe.github.io/biblioteca-front/pages/livros/gerenciaLivro.html");
        driver.findElement(By.cssSelector("#tabela_livros > tbody > tr:nth-child(1) > " +
                "td:nth-child(2) > div > a:nth-child(3)")).click();

        driver.navigate().back();

        driver.navigate().refresh();

        driver.navigate().forward();

        driver.navigate().to("https://www.google.com/");

        Thread.sleep(2000);

        String urlAtual= driver.getCurrentUrl();

        assertEquals("https://www.google.com/", urlAtual);

    }
}
