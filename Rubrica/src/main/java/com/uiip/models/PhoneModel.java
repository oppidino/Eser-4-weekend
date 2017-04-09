package com.uiip.models;

public class PhoneModel {

    private String tipo, brand, opsys;

    public PhoneModel() {
    }

    public PhoneModel(String tipo, String brand, String opsys) {
        this.tipo = tipo;
        this.brand = brand;
        this.opsys = opsys;
    }

    public String getName() {
        return tipo;
    }

    public void setName(String tipo) {
        this.tipo = tipo;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getOpsys() {
        return opsys;
    }

    public void setOpsys(String opsys) {
        this.opsys = opsys;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tipo: ").append(tipo).append("\n")
                .append("Brand: ").append(brand).append("\n")
                .append("OpSys: ").append(opsys);
        return sb.toString();
    }

}
