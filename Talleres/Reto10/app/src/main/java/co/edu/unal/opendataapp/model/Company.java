package co.edu.unal.opendataapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Company {

    @SerializedName("no")
    @Expose
    private String no;
    @SerializedName("nit")
    @Expose
    private String nit;
    @SerializedName("razon_social")
    @Expose
    private String razonSocial;
    @SerializedName("supervisor")
    @Expose
    private String supervisor;
    @SerializedName("regi_n")
    @Expose
    private String regiN;
    @SerializedName("departamento_domicilio")
    @Expose
    private String departamentoDomicilio;
    @SerializedName("ciudad_domicilio")
    @Expose
    private String ciudadDomicilio;
    @SerializedName("ciiu")
    @Expose
    private String ciiu;
    @SerializedName("macrosector")
    @Expose
    private String macrosector;
    @SerializedName("ingresos_operacionales_2018")
    @Expose
    private String ingresosOperacionales2018;
    @SerializedName("ganancia_perdida_2018")
    @Expose
    private String gananciaPerdida2018;
    @SerializedName("total_activos_2018")
    @Expose
    private String totalActivos2018;
    @SerializedName("total_pasivos_2018")
    @Expose
    private String totalPasivos2018;
    @SerializedName("total_patrimonio_2018")
    @Expose
    private String totalPatrimonio2018;
    @SerializedName("ingresos_operacionales_2017")
    @Expose
    private String ingresosOperacionales2017;
    @SerializedName("ganancia_perdida_2017")
    @Expose
    private String gananciaPerdida2017;
    @SerializedName("total_activos_2017")
    @Expose
    private String totalActivos2017;
    @SerializedName("total_pasivos_2017")
    @Expose
    private String totalPasivos2017;
    @SerializedName("total_patrimonio_2017")
    @Expose
    private String totalPatrimonio2017;
    @SerializedName("grupo_en_niif")
    @Expose
    private String grupoEnNiif;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getRegiN() {
        return regiN;
    }

    public void setRegiN(String regiN) {
        this.regiN = regiN;
    }

    public String getDepartamentoDomicilio() {
        return departamentoDomicilio;
    }

    public void setDepartamentoDomicilio(String departamentoDomicilio) {
        this.departamentoDomicilio = departamentoDomicilio;
    }

    public String getCiudadDomicilio() {
        return ciudadDomicilio;
    }

    public void setCiudadDomicilio(String ciudadDomicilio) {
        this.ciudadDomicilio = ciudadDomicilio;
    }

    public String getCiiu() {
        return ciiu;
    }

    public void setCiiu(String ciiu) {
        this.ciiu = ciiu;
    }

    public String getMacrosector() {
        return macrosector;
    }

    public void setMacrosector(String macrosector) {
        this.macrosector = macrosector;
    }

    public String getIngresosOperacionales2018() {
        return ingresosOperacionales2018;
    }

    public void setIngresosOperacionales2018(String ingresosOperacionales2018) {
        this.ingresosOperacionales2018 = ingresosOperacionales2018;
    }

    public String getGananciaPerdida2018() {
        return gananciaPerdida2018;
    }

    public void setGananciaPerdida2018(String gananciaPerdida2018) {
        this.gananciaPerdida2018 = gananciaPerdida2018;
    }

    public String getTotalActivos2018() {
        return totalActivos2018;
    }

    public void setTotalActivos2018(String totalActivos2018) {
        this.totalActivos2018 = totalActivos2018;
    }

    public String getTotalPasivos2018() {
        return totalPasivos2018;
    }

    public void setTotalPasivos2018(String totalPasivos2018) {
        this.totalPasivos2018 = totalPasivos2018;
    }

    public String getTotalPatrimonio2018() {
        return totalPatrimonio2018;
    }

    public void setTotalPatrimonio2018(String totalPatrimonio2018) {
        this.totalPatrimonio2018 = totalPatrimonio2018;
    }

    public String getIngresosOperacionales2017() {
        return ingresosOperacionales2017;
    }

    public void setIngresosOperacionales2017(String ingresosOperacionales2017) {
        this.ingresosOperacionales2017 = ingresosOperacionales2017;
    }

    public String getGananciaPerdida2017() {
        return gananciaPerdida2017;
    }

    public void setGananciaPerdida2017(String gananciaPerdida2017) {
        this.gananciaPerdida2017 = gananciaPerdida2017;
    }

    public String getTotalActivos2017() {
        return totalActivos2017;
    }

    public void setTotalActivos2017(String totalActivos2017) {
        this.totalActivos2017 = totalActivos2017;
    }

    public String getTotalPasivos2017() {
        return totalPasivos2017;
    }

    public void setTotalPasivos2017(String totalPasivos2017) {
        this.totalPasivos2017 = totalPasivos2017;
    }

    public String getTotalPatrimonio2017() {
        return totalPatrimonio2017;
    }

    public void setTotalPatrimonio2017(String totalPatrimonio2017) {
        this.totalPatrimonio2017 = totalPatrimonio2017;
    }

    public String getGrupoEnNiif() {
        return grupoEnNiif;
    }

    public void setGrupoEnNiif(String grupoEnNiif) {
        this.grupoEnNiif = grupoEnNiif;
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        if( this.no != null ) stringBuilder.append("No. " +no + '\n');
        if( this.razonSocial != null ) stringBuilder.append(razonSocial + '\n');
        if( this.departamentoDomicilio != null ) stringBuilder.append(departamentoDomicilio + '\n');
        if( this.ciiu != null ) stringBuilder.append(ciiu + '\n');
        if( this.gananciaPerdida2018 != null )
            stringBuilder.append("Ingresos netos 2018: $" +gananciaPerdida2018 + '\n');
        if( this.totalPatrimonio2018 != null )
            stringBuilder.append("Patrimonio 2018: $" + totalPatrimonio2018 + '\n');
        return stringBuilder.toString();
    }

}
