package com.it.bd.tests;

import com.it.bd.drivers.BaseDriver;
import com.it.bd.pages.DashboardPage;
import org.testng.annotations.Test;

public class DashboardTest extends BaseDriver {
    @Test(priority = 0)
    public void dashBoardTest()throws InterruptedException {
        DashboardPage dashboardPage = new DashboardPage();

        dashboardPage.checkDashboard();
        dashboardPage.clickAdmin();
    }
}
