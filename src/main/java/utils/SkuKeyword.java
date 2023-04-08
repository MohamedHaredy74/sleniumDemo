package utils;

public enum SkuKeyword {

    //APPLE_CAM or SF_PRO_11 or SCI_FAITH
    SOUND_FORG_PRO11("SF_PRO_11"),APPLE_CAM("APPLE_CAM"),SCIENCE_AND_FAITH("SCI_FAITH");
    private String value;

    SkuKeyword(String value)
    {
        this.value=value;

    }
    @Override
    public  String toString()
    {
        return value.toString();
    }


}
