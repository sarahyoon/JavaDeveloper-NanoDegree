package edu.udacity.java.nano.chat;

        import org.junit.jupiter.api.Test;
        import org.junit.runner.RunWith;
        import org.openqa.selenium.*;
        import org.openqa.selenium.htmlunit.HtmlUnitDriver;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.FluentWait;
        import org.openqa.selenium.support.ui.Wait;
        import org.openqa.selenium.support.ui.WebDriverWait;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.context.SpringBootTest;
        import org.springframework.test.context.junit4.SpringRunner;

        import java.util.concurrent.TimeUnit;
        import java.util.function.Function;

        import static com.google.common.util.concurrent.Futures.withTimeout;
        import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {WebSocketChatServerTest.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WebSocketChatServerTest{
    @Autowired
    private WebSocketChatServer webSocketChatServer;

    @Autowired
    private WebDriver webDriver;

    @Autowired
    private WebDriver webDriver2;

    private String test_url = "http://localhost:8080";

    @Test
    public void loginAndJoinTest()
    {
        webDriver = new HtmlUnitDriver(true);
        webDriver.get(test_url);
        String inputName="aaa";

        WebElement username = webDriver.findElement(By.name("username"));
        username.sendKeys(inputName);

        WebElement login = webDriver.findElement(By.className("submit"));
        login.click();

        System.out.println("!!! Login Success !!!");

       assertThat(webDriver.findElement(By.id ("username")).getAttribute("innerHTML")).isEqualTo(inputName);


        System.out.println("!!! Chat Ready !!!");


    }


    @Test
    public void chatAndLeave()
    {
        webDriver = new HtmlUnitDriver(true);
        webDriver2 = new HtmlUnitDriver(true);

        String username="aaa";
        webDriver.get(test_url+"/index?username="+username);

        String username2="bbb";
        webDriver2.get(test_url+"/index?username="+username2);

        WebElement sendText = webDriver.findElement(By.id("msg"));
        sendText.sendKeys("send text test");

        WebElement sendButton = webDriver.findElement(By.className("send"));
        sendButton.click();


        WebDriverWait wait = new WebDriverWait(webDriver2, 30);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("message-content")));
        System.out.println(element.getAttribute("textContent").length());
        assertThat(element.getAttribute("textContent").substring(4,18)).isEqualTo("send text test");

        System.out.println("--------------SEND CHAT SUCCESS-----------");

        WebElement leaveChat = webDriver.findElement(By.className("exit"));
        leaveChat.click();

        assertThat(webDriver.findElement(By.className("submit")).getText().equals("login"));
        System.out.println("--------------LOGOUT SUCCESS-----------");

    }

}