package apptienda;

import java.util.ArrayList;

public class RegistroUsuarios {

    ArrayList<Usuario> lista;

    public RegistroUsuarios() {
        lista = new ArrayList<>();
    }

    public void agregarUsuario(Usuario usu) {
        lista.add(usu);
    }

    public int numRegs() {
        return lista.size();
    }

    public boolean busqueda(String nick, String contra) {
        boolean paso = false;
        String usu = "", con = "";

        for (int i = 0; i < numRegs(); i++) {
            usu = lista.get(i).getNickName();
            con = lista.get(i).getContrasena();
            if (usu.equals(nick) && con.equals(contra)) {
                paso = true;
                break;
            } else {
                paso = false;
            }
        }

        return paso;
    }
    
    public int busqueda(String nick){
        int num=0;
        
        for(int i=0;i<lista.size();i++){
            if(lista.get(i).equals(nick))
                num=i;
        }
        
        return num;
    }
    
    public String getNumEmp(int num){
        return lista.get(num).getNumEmpleado();
    }
    
    public String getNombreEmp(int num){
        return lista.get(num).getNombre();
    }

    @Override
    public String toString() {
        String sal = "";

        for (int i = 0; i < lista.size(); i++) {
            sal += lista.get(i).toString();
        }

        return sal;
    }

}
