import java.sql.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.FileOutputStream;

public class PlanetaApp {

    static final String URL = "jdbc:mysql://localhost:3306/simulador_planetas";
    static final String USER = "giordana";
    static final String PASS = "123456";

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            System.out.println("Conectado ao MySQL!");

            // Exemplo: Buscar dados do planeta
            String sqlSelect = "SELECT * FROM planetas WHERE nome = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sqlSelect)) {
                stmt.setString(1, "Terra");
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    String nome = rs.getString("nome");
                    double massa = rs.getDouble("massa");
                    double raio = rs.getDouble("raio");
                    double densidade = rs.getDouble("densidade");
                    String atm = rs.getString("atm");
                    double temp = rs.getDouble("temperatura");
                    String superficie = rs.getString("superficie");
                    double rotacao = rs.getDouble("rotacao");
                    double inclinacao = rs.getDouble("inclinacao");
                    double distancia = rs.getDouble("distancia");

                    // Cálculos
                    double G = 6.674e-11;
                    double gravidade = (G * massa) / (raio * raio);
                    double ve = Math.sqrt(2 * G * massa / raio) / 1000;

                    // Possível vida
                    String vidaTexto = "Improvável vida";
                    boolean atmGood = atm.equalsIgnoreCase("oxigenio") || atm.equalsIgnoreCase("nitrogenio");
                    if (temp >= 0 && temp <= 50 && gravidade >= 5 && gravidade <= 20 && atmGood)
                        vidaTexto = "Possível vida complexa";

                    // Gerar PDF
                    gerarPDF(nome, massa, raio, densidade, atm, temp, superficie, rotacao, inclinacao, distancia, gravidade, ve, vidaTexto);
                    System.out.println("PDF gerado com sucesso!");
                } else {
                    System.out.println("Planeta não encontrado.");
                }
            }

        } catch (SQLException | DocumentException | java.io.IOException e) {
            e.printStackTrace();
        }
    }

    static void gerarPDF(String nome, double massa, double raio, double densidade, String atm, double temp,
                         String superficie, double rotacao, double inclinacao, double distancia,
                         double gravidade, double ve, String vidaTexto) throws DocumentException, java.io.IOException {

        Document documento = new Document();
        PdfWriter.getInstance(documento, new FileOutputStream("RelatorioPlaneta.pdf"));
        documento.open();

        documento.add(new Paragraph("===== Relatório do Planeta ====="));
        documento.add(new Paragraph("Nome: " + nome));
        documento.add(new Paragraph("Massa: " + massa + " kg"));
        documento.add(new Paragraph("Raio: " + raio + " m"));
        documento.add(new Paragraph("Densidade: " + densidade + " kg/m³"));
        documento.add(new Paragraph("Atmosfera: " + atm));
        documento.add(new Paragraph("Temperatura: " + temp + " °C"));
        documento.add(new Paragraph("Superfície: " + superficie));
        documento.add(new Paragraph("Rotação: " + rotacao + " h"));
        documento.add(new Paragraph("Inclinação: " + inclinacao + " °"));
        documento.add(new Paragraph("Distância da estrela: " + distancia + " UA"));
        documento.add(new Paragraph("Gravidade calculada: " + gravidade + " m/s²"));
        documento.add(new Paragraph("Velocidade de escape: " + ve + " km/s"));
        documento.add(new Paragraph("Possível vida: " + vidaTexto));
        documento.add(new Paragraph("=================================="));

        documento.close();
    }
}
