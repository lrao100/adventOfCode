package day3;

public class GammaEpsilon {
    private String gammaString;
    private String epsilonString;

    public GammaEpsilon(String gamma, String epsilon) {
        this.gammaString = gamma;
        this.epsilonString = epsilon;
    }

    public String getGammaString() {
        return gammaString;
    }

    public String getEpsilonString() {
        return epsilonString;
    }

    public void setEpsilonString(String epsilonString) {
        this.epsilonString = epsilonString;
    }

    public void setGammaString(String gammaString) {
        this.gammaString = gammaString;
    }

    public int getGammaValue() {
        return Integer.parseInt(gammaString, 2);
    }

    public int getEpsilonValue() {
        return Integer.parseInt(epsilonString, 2);
    }
}
