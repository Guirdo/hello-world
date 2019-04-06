package mx.edu.itch.sistemas.seblab.InterfazGrafica;

import java.awt.LayoutManager;
import javax.swing.JDialog;

public class DialogoModal extends JDialog{
    
    public DialogoModal(String titulo, String defaultExit, LayoutManager layoutManager){
        this.setTitle(titulo);
        this.setModal(true);
        this.setLayout(layoutManager);
        
        switch(defaultExit){
            case "dispose":
                this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                break;
            case "nothing":
                this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
                break;
        }
    }
    
    public DialogoModal(String titulo, String defaultExit){
        this.setTitle(titulo);
        this.setModal(true);
        
        switch(defaultExit){
            case "dispose":
                this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                break;
            case "nothing":
                this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
                break;
        }
    }

}
