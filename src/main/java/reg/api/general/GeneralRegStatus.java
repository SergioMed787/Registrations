package reg.api.general;

public abstract class GeneralRegStatus {
    public String activeStatus() {
        return  GeneralRegStatusEnum.ACTIVE.toString();
    }

    public String inactiveStatus() {
        return  GeneralRegStatusEnum.INACTIVE.toString();
    }
}
