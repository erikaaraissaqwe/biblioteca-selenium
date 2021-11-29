import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

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

//    Teste com o título de página
//    @Test
//    @Order(19)
//    public void titlePageCadastarSalvarTest() throws InterruptedException {
//        driver.get("https://erikaaraissaqwe.github.io/biblioteca-front/pages/pessoas/cadastrarPessoa.html");
//        WebElement nome = driver.findElement(By.id("nome"));
//        WebElement email = driver.findElement(By.className("emails"));
//        WebElement dataNasc = driver.findElement(By.id("dataNascimento"));
//        WebElement endereco = driver.findElement(By.id("endereco"));
//        WebElement cpf = driver.findElement(By.id("cpf"));
//        WebElement telefone = driver.findElement(By.className("telefones"));
//        WebElement profissao = driver.findElement(By.id("profissao"));
//        WebElement numero = driver.findElement(By.id("numero"));
//        WebElement cep = driver.findElement(By.id("cep"));
//
//        nome.sendKeys("Erika Raissa");
//        email.sendKeys("erikaaraissaqwe@gmail.com");
//        dataNasc.sendKeys("17/07/2000");
//        endereco.sendKeys("Rua da Casinha Torta");
//        cpf.sendKeys("144.739.710-07");
//        telefone.sendKeys("33435581");
//        profissao.sendKeys("Aluno");
//        numero.sendKeys("51");
//        cep.sendKeys("14815000");
//        Thread.sleep(2000);
//
//        driver.findElement(By.id("save")).click();
//        Thread.sleep(2000);
//        driver.switchTo().alert().accept();
//        Thread.sleep(2000);
//        String titulo = driver.getTitle();
//        assertEquals("Pessoas", titulo);
//    }
//
//    //Teste com a url da página
//    @Test
//    @Order(20)
//    public void urlPageCadastarSalvarTest() throws InterruptedException {
//        driver.get("https://erikaaraissaqwe.github.io/biblioteca-front/pages/pessoas/cadastrarPessoa.html");
//        WebElement nome = driver.findElement(By.id("nome"));
//        WebElement email = driver.findElement(By.className("emails"));
//        WebElement dataNasc = driver.findElement(By.id("dataNascimento"));
//        WebElement endereco = driver.findElement(By.id("endereco"));
//        WebElement cpf = driver.findElement(By.id("cpf"));
//        WebElement telefone = driver.findElement(By.className("telefones"));
//        WebElement profissao = driver.findElement(By.id("profissao"));
//        WebElement numero = driver.findElement(By.id("numero"));
//        WebElement cep = driver.findElement(By.id("cep"));
//
//        nome.sendKeys("Erika Raissa");
//        email.sendKeys("erikaaraissaqwe@gmail.com");
//        dataNasc.sendKeys("17/07/2000");
//        endereco.sendKeys("Rua da Casinha Torta");
//        cpf.sendKeys("144.739.710-07");
//        telefone.sendKeys("33435581");
//        profissao.sendKeys("Aluno");
//        numero.sendKeys("51");
//        cep.sendKeys("14815000");
//        Thread.sleep(2000);
//
//        String urlEsperada = "https://erikaaraissaqwe.github.io/biblioteca-front/pages/pessoas/gerenciaPessoa.html";
//        driver.findElement(By.id("save")).click();
//        Thread.sleep(2000);
//        driver.switchTo().alert().accept();
//        Thread.sleep(2000);
//        String urlAtual= driver.getCurrentUrl();
//        Thread.sleep(2000);
//        assertEquals(urlEsperada, urlAtual);
//    }
//
//    //Teste com o título de página
//    @Test
//    @Order(21)
//    public void titlePageListarSalvarTest() throws InterruptedException {
//        driver.get("https://erikaaraissaqwe.github.io/biblioteca-front/pages/pessoas/cadastrarPessoa.html");
//        driver.findElement(By.cssSelector("#list > a")).click();
//        Thread.sleep(2000);
//        String titulo = driver.getTitle();
//        assertEquals("Pessoas", titulo);
//    }
//
//    //Teste com a url da página
//    @Test
//    @Order(22)
//    public void urlPageListarTest() throws InterruptedException {
//        driver.get("https://erikaaraissaqwe.github.io/biblioteca-front/pages/pessoas/cadastrarPessoa.html");
//        String urlEsperada = "https://erikaaraissaqwe.github.io/biblioteca-front/pages/pessoas/gerenciaPessoa.html";
//        driver.findElement(By.cssSelector("#list > a")).click();
//        String urlAtual= driver.getCurrentUrl();
//        Thread.sleep(2000);
//        assertEquals(urlEsperada, urlAtual);
//    }
//
//    //Teste com o título de página
//    @Test
//    @Order(23)
//    public void titlePageInicialTest() throws InterruptedException {
//        driver.get("https://erikaaraissaqwe.github.io/biblioteca-front/pages/pessoas/gerenciaPessoa.html");
//        driver.findElement(By.cssSelector("#home > a")).click();
//        Thread.sleep(2000);
//        String titulo = driver.getTitle();
//        assertEquals("Biblioteca", titulo);
//    }
//
//    //Teste com a url da página
//    @Test
//    @Order(24)
//    public void urlPageInicialTest() throws InterruptedException {
//        driver.get("https://erikaaraissaqwe.github.io/biblioteca-front/pages/pessoas/gerenciaPessoa.html");
//        String urlEsperada = "https://erikaaraissaqwe.github.io/biblioteca-front/pages/index.html";
//        driver.findElement(By.cssSelector("#home > a")).click();
//        String urlAtual= driver.getCurrentUrl();
//        Thread.sleep(2000);
//        assertEquals(urlEsperada, urlAtual);
//    }
//
//    //Teste com form de cadastro
//    @Test
//    @Order(25)
//    public void formPageCadastroTest() throws InterruptedException {
//        driver.get("https://erikaaraissaqwe.github.io/biblioteca-front/pages/pessoas/cadastrarPessoa.html");
//
//        WebElement nome = driver.findElement(By.id("nome"));
//        WebElement email = driver.findElement(By.className("emails"));
//        WebElement dataNasc = driver.findElement(By.id("dataNascimento"));
//        WebElement endereco = driver.findElement(By.id("endereco"));
//        WebElement cpf = driver.findElement(By.id("cpf"));
//        WebElement telefone = driver.findElement(By.className("telefones"));
//        WebElement profissao = driver.findElement(By.id("profissao"));
//        WebElement numero = driver.findElement(By.id("numero"));
//        WebElement cep = driver.findElement(By.id("cep"));
//
//        nome.sendKeys("Erika Raissa");
//        email.sendKeys("erikaaraissaqwe@gmail.com");
//        dataNasc.sendKeys("17/07/2000");
//        endereco.sendKeys("Rua da Casinha Torta");
//        cpf.sendKeys("144.739.710-07");
//        telefone.sendKeys("33435581");
//        profissao.sendKeys("Aluno");
//        numero.sendKeys("51");
//        cep.sendKeys("14815000");
//
//        Thread.sleep(2000);
//
//        assertAll(
//                () -> assertTrue(nome.isDisplayed()),
//                () -> assertEquals("Erika Raissa", nome.getAttribute("value")),
//                () -> assertTrue(email.isDisplayed()),
//                () -> assertEquals("erikaaraissaqwe@gmail.com", email.getAttribute("value")),
//                () -> assertTrue(dataNasc.isDisplayed()),
//                () -> assertEquals("2000-07-17", dataNasc.getAttribute("value")),
//                () -> assertTrue(endereco.isDisplayed()),
//                () -> assertEquals("Rua da Casinha Torta", endereco.getAttribute("value")),
//                () -> assertTrue(cpf.isDisplayed()),
//                () -> assertEquals("144.739.710-07", cpf.getAttribute("value")),
//                () -> assertTrue(telefone.isDisplayed()),
//                () -> assertEquals("33435581", telefone.getAttribute("value")),
//                () -> assertTrue(profissao.isDisplayed()),
//                () -> assertEquals("Aluno", profissao.getAttribute("value")),
//                () -> assertTrue(numero.isDisplayed()),
//                () -> assertEquals("51", numero.getAttribute("value")),
//                () -> assertTrue(cep.isDisplayed()),
//                () -> assertEquals("14815000", cep.getAttribute("value"))
//
//        );
//    }
//
//
//    //
//    //Teste com form de edição
//    @Test
//    @Order(26)
//    public void formPageEditarTest() throws InterruptedException {
//        driver.get("https://erikaaraissaqwe.github.io/biblioteca-front/pages/pessoas/gerenciaPessoa.html");
//        driver.findElement(By.cssSelector("#tabela_pessoas > tbody > tr:nth-child(1) > " +
//                "td:nth-child(2) > div > a:nth-child(3)")).click();
//        Thread.sleep(3000);
//
//        WebElement nome = driver.findElement(By.id("nome"));
//        List<WebElement> emails = driver.findElements(By.className("emails"));
//        WebElement dataNasc = driver.findElement(By.id("dataNascimento"));
//        WebElement endereco = driver.findElement(By.id("endereco"));
//        WebElement cpf = driver.findElement(By.id("cpf"));
//        List<WebElement> telefones = driver.findElements(By.className("telefones"));
//        WebElement profissao = driver.findElement(By.id("profissao"));
//        WebElement numero = driver.findElement(By.id("numero"));
//        WebElement cep = driver.findElement(By.id("cep"));
//
//        Thread.sleep(2000);
//
//        assertAll(
//                () -> assertTrue(nome.isDisplayed()),
//                () -> assertEquals("Naowi Ferreira", nome.getAttribute("value")),
//                () -> assertTrue(emails.get(0).isDisplayed()),
//                () -> assertEquals("Naowi01@gmail.com", emails.get(0).getAttribute("value")),
//                () -> assertTrue(emails.get(1).isDisplayed()),
//                () -> assertEquals("NaowiFerreira@gmail.com", emails.get(1).getAttribute("value")),
//                () -> assertTrue(dataNasc.isDisplayed()),
//                () -> assertEquals("1999-01-30", dataNasc.getAttribute("value")),
//                () -> assertTrue(endereco.isDisplayed()),
//                () -> assertEquals("Marta Clemente", endereco.getAttribute("value")),
//                () -> assertTrue(cpf.isDisplayed()),
//                () -> assertEquals("05575072002", cpf.getAttribute("value")),
//                () -> assertTrue(telefones.get(0).isDisplayed()),
//                () -> assertEquals("(00)0000-0001", telefones.get(0).getAttribute("value")),
//                () -> assertTrue(telefones.get(1).isDisplayed()),
//                () -> assertEquals("(99)99999-9999", telefones.get(1).getAttribute("value")),
//                () -> assertTrue(profissao.isDisplayed()),
//                () -> assertEquals("Aluno", profissao.getAttribute("value")),
//                () -> assertTrue(numero.isDisplayed()),
//                () -> assertEquals("01", numero.getAttribute("value")),
//                () -> assertTrue(cep.isDisplayed()),
//                () -> assertEquals("14715-000", cep.getAttribute("value"))
//        );
//    }
//
//    //Teste com form de cadastro inválido
//    @Test
//    @Order(27)
//    public void formPageCadastroInvalidTest() throws InterruptedException {
//        driver.get("https://erikaaraissaqwe.github.io/biblioteca-front/pages/pessoas/cadastrarPessoa.html");
//
//        driver.findElement(By.id("save")).click();
//
//        Thread.sleep(3000);
//
//        String requerid = "Este campo é requerido.";
//
//        WebElement nome = driver.findElement(By.id("reqNome"));
//        WebElement email = driver.findElement(By.id("reqEmail"));
//        WebElement dataNasc = driver.findElement(By.id("reqData"));
//        WebElement endereco = driver.findElement(By.id("reqEnd"));
//        WebElement cpf = driver.findElement(By.id("reqCpf"));
//        WebElement telefone = driver.findElement(By.id("reqTel"));
//        WebElement numero = driver.findElement(By.id("reqNum"));
//        WebElement cep = driver.findElement(By.id("reqCep"));
//
//        Thread.sleep(2000);
//
//        assertAll(
//                () -> assertTrue(nome.isDisplayed()),
//                () -> assertEquals(requerid, nome.getText()),
//                () -> assertTrue(email.isDisplayed()),
//                () -> assertEquals(requerid, email.getText()),
//                () -> assertTrue(dataNasc.isDisplayed()),
//                () -> assertEquals(requerid, dataNasc.getText()),
//                () -> assertTrue(endereco.isDisplayed()),
//                () -> assertEquals(requerid, endereco.getText()),
//                () -> assertTrue(cpf.isDisplayed()),
//                () -> assertEquals(requerid, cpf.getText()),
//                () -> assertTrue(telefone.isDisplayed()),
//                () -> assertEquals(requerid, telefone.getText()),
//                () -> assertTrue(numero.isDisplayed()),
//                () -> assertEquals(requerid, numero.getText()),
//                () -> assertTrue(cep.isDisplayed()),
//                () -> assertEquals(requerid, cep.getText())
//
//        );
//    }
//
//    //Teste com DropDown
//    @Test
//    @Order(28)
//    public void formPageDropDownTest() throws InterruptedException {
//        driver.get("https://erikaaraissaqwe.github.io/biblioteca-front/pages/pessoas/cadastrarPessoa.html");
//
//        Thread.sleep(3000);
//
//        WebElement profissaoSelect = driver.findElement(By.id("profissao"));
//
//        Select dd = new Select(profissaoSelect);
//        dd.selectByVisibleText("Aluno");
//
//        Thread.sleep(2000);
//
//        assertAll(
//                () -> assertTrue(profissaoSelect.isDisplayed()),
//                () -> assertTrue(profissaoSelect.isEnabled()),
//                () -> assertEquals("Aluno", profissaoSelect.getAttribute("value"))
//
//        );
//    }
//
//    //Teste com Forward
//    @Test
//    @Order(29)
//    public void formPageBack() throws InterruptedException {
//
//        driver.get("https://erikaaraissaqwe.github.io/biblioteca-front/pages/pessoas/gerenciaPessoa.html");
//        driver.findElement(By.cssSelector("#tabela_pessoas > tbody > tr:nth-child(1) > " +
//                "td:nth-child(2) > div > a:nth-child(3)")).click();
//
//        driver.navigate().back();
//
//        Thread.sleep(2000);
//
//        String urlAtual= driver.getCurrentUrl();
//
//        assertEquals("https://erikaaraissaqwe.github.io/biblioteca-front/pages/pessoas/gerenciaPessoa.html", urlAtual);
//
//    }
//
//    //Teste com Forward
//    @Test
//    @Order(30)
//    public void formPageForward() throws InterruptedException {
//
//        driver.get("https://erikaaraissaqwe.github.io/biblioteca-front/pages/pessoas/gerenciaPessoa.html");
//        driver.findElement(By.cssSelector("#tabela_pessoas > tbody > tr:nth-child(1) > " +
//                "td:nth-child(2) > div > a:nth-child(3)")).click();
//
//        driver.navigate().forward();
//
//        Thread.sleep(2000);
//
//        String urlAtual= driver.getCurrentUrl();
//
//        assertEquals("https://erikaaraissaqwe.github.io/biblioteca-front/pages/pessoas/editarPessoa.html", urlAtual);
//
//    }
//
//    //Teste com Nagivate
//    @Test
//    @Order(31)
//    public void formPageNagivate() throws InterruptedException {
//
//        driver.get("https://erikaaraissaqwe.github.io/biblioteca-front/pages/pessoas/gerenciaPessoa.html");
//        driver.findElement(By.cssSelector("#tabela_pessoas > tbody > tr:nth-child(1) > " +
//                "td:nth-child(2) > div > a:nth-child(3)")).click();
//
//        driver.navigate().back();
//
//        driver.navigate().refresh();
//
//        driver.navigate().forward();
//
//        driver.navigate().to("https://www.google.com/");
//
//        Thread.sleep(2000);
//
//        String urlAtual= driver.getCurrentUrl();
//
//        assertEquals("https://www.google.com/", urlAtual);
//
//    }
}
