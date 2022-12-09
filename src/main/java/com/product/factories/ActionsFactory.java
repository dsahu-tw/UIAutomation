package com.product.factories;

import com.product.driver.DriverManager;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.openqa.selenium.interactions.Actions;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public  final class ActionsFactory {

    @SneakyThrows
    public static Actions startActions() {
        return new Actions(DriverManager.getDriver());
    }
}
