package gx.domain;

public class City {
    private String CityCode;
    private String City;
    private String CountryCode;

    public String getCityCode() {
        return CityCode;
    }

    public void setCityCode(String cityCode) {
        CityCode = cityCode;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }

    @Override
    public String toString() {
        return "City{" +
                "CityCode='" + CityCode + '\'' +
                ", City='" + City + '\'' +
                ", CountryCode='" + CountryCode + '\'' +
                '}';
    }
}
