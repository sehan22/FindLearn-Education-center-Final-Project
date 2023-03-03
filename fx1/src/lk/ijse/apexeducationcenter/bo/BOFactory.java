package lk.ijse.apexeducationcenter.bo;

import lk.ijse.apexeducationcenter.bo.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){
    }
    public static BOFactory getBoFactory(){
        return (boFactory==null)? boFactory=new BOFactory() : boFactory;
    }

    public enum BOTypes{
        ADMIN,LOGIN,FINANCIAL,HUMANRESOURSE,REPORT,TEACHER
    }

    public SuperBO getBO(BOTypes boTypes){
        switch (boTypes) {
            case ADMIN:
                return new AdminDashboardBOImpl();
            case LOGIN:
                return new ApexLoginBOImpl();
            case FINANCIAL:
                return new FinancialAffairsDashboardBOImpl();
            case HUMANRESOURSE:
                return new HumanResourseManagerBOImpl();
            case REPORT:
                return new ReportBOImpl();
            case TEACHER:
                return new TeacherDashboardBOImpl();
            default:
                return null;
        }
    }
}
