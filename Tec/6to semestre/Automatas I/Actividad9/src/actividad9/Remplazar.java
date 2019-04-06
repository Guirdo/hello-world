package actividad9;

import java.awt.LayoutManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import mx.edu.itch.sistemas.seblab.InterfazGrafica.AreaTexto;
import mx.edu.itch.sistemas.seblab.InterfazGrafica.Boton;
import mx.edu.itch.sistemas.seblab.InterfazGrafica.DialogoModal;
import mx.edu.itch.sistemas.seblab.InterfazGrafica.PaletaColores;
import net.miginfocom.swing.MigLayout;

public class Remplazar extends DialogoModal {

    private Pattern pattern;
    private Matcher matcher;
    private String buscado;
    private DefaultHighlighter.DefaultHighlightPainter hP;
    private Highlighter h;
    private AreaTexto area;

    public Remplazar(AreaTexto area) {
        super("Encontrar y remplazar", "dispose", new MigLayout("wrap 4", "[][][][]", "[]30[]"));
        this.setModal(false);
        this.setAlwaysOnTop(true);

        this.area = area;
        buscado = "";
        hP = new DefaultHighlighter.DefaultHighlightPainter(PaletaColores.LIGHT_STEEL_BLUE_1);
        h = this.area.getHighlighter();
        h.removeAllHighlights();

        JComboBox cbBuscar = new JComboBox();
        cbBuscar.setEditable(true);

        JComboBox cbRemplazar = new JComboBox();
        cbRemplazar.setEditable(true);

        Boton btnBuscar = new Boton("Buscar", PaletaColores.IRISH_BLUE, PaletaColores.LINX_WHITE);
        btnBuscar.addActionListener((ActionEvent) -> {
            String buscar = cbBuscar.getSelectedItem().toString();
            String texto = area.getText();
            if (!buscar.isEmpty()) {
                if (buscado.isEmpty() || !buscado.equals(buscar)) {
                    this.buscado = buscar;
                    pattern = Pattern.compile("(?i)" + buscar);
                    matcher = pattern.matcher(texto);
                    matcher.find();
                } else if (buscado.equals(buscar)) {
                    h.removeAllHighlights();
                    if (!matcher.find()) {
                        matcher = pattern.matcher(texto);
                        matcher.find();
                    }
                }

                try {
                    h.addHighlight(matcher.start(), matcher.end(), hP);
                } catch (BadLocationException ex) {
                    System.out.println("Error");
                }
            }

        });

        Boton btnRemplazar = new Boton("Remplazar todo", PaletaColores.IRISH_BLUE, PaletaColores.LINX_WHITE);
        btnRemplazar.addActionListener((ActionEvent) -> {
            String buscar = cbBuscar.getSelectedItem().toString();
            String remplazar = cbRemplazar.getSelectedItem().toString();
            String texto = area.getText();

            if (!buscar.isEmpty() && !remplazar.isEmpty()) {
                if (!buscado.equals(buscar)) {
                    cbRemplazar.addItem(buscar);
                    cbBuscar.addItem(buscar);
                }

                this.buscado = buscar;
                pattern = Pattern.compile("(?i)" + buscar);
                matcher = pattern.matcher(texto);
                texto = matcher.replaceAll(remplazar);
                this.area.setText("");
                this.area.setText(texto);
            }

        });

        Boton btnRempPrimero = new Boton("Remplezar primero", PaletaColores.IRISH_BLUE, PaletaColores.LINX_WHITE);
        btnRempPrimero.addActionListener((ActionEvent) -> {
            String buscar = "";
            String remplazar = "";
            remplazar = cbRemplazar.getSelectedItem().toString();
            buscar = cbBuscar.getSelectedItem().toString();
            String texto = area.getText();

            if (!buscado.equals(buscar)) {
                cbRemplazar.addItem(buscar);
            }

            if (!remplazar.isEmpty() && !buscar.isEmpty()) {
                this.buscado = buscar;
                pattern = Pattern.compile("(?i)" + buscar);
                matcher = pattern.matcher(texto);
                if (matcher.find()) {
                    texto = matcher.replaceFirst(remplazar);
                    this.area.setText("");
                    this.area.setText(texto);
                } else {
                    new MensajeError("Mensaje error", "dispose", "No se han encontrado coincidencias").setVisible(true);
                }
            } else {
                new MensajeError("Campos vacios", "dispose", "Inserte la palabra a buscar o la palabra de remplazo").setVisible(true);
            }
        });

        this.add(new JLabel("Buscar: "), "sg a");
        this.add(cbBuscar, "growx,span 3");
        this.add(new JLabel("Remplazar con: "), "sg a");
        this.add(cbRemplazar, "growx,span 3");
        this.add(btnRemplazar, "span 2,right");
        this.add(btnRempPrimero, "");
        this.add(btnBuscar);

        this.pack();
        this.setLocationRelativeTo(null);
    }

}
