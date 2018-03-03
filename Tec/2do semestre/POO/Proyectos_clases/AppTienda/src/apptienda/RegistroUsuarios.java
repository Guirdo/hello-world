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

        if (numRegs() > 1) {
            for (int i = 0; i < numRegs(); i++) {
                usu = lista.get(i).getNickName();
                con = lista.get(i).getContrasena();
                System.out.println("Se busco: "+usu+"     "+con);
                if (usu.equals(nick) && con.equals(contra)) {
                    paso = true;
                    break;
                } else {
                    paso = false;
                }
            }
        } else {
            usu = lista.get(0).getNickName();
            con = lista.get(0).getContrasena();
            System.out.println(usu+"\n"+con);
            if (usu.equals(nick) && con.equals(contra)) {
                paso = true;
            } else if(usu.equals(nick) && !con.equals(contra)){
                paso = false;
            }else if(!usu.equals(nick) && con.equals(contra)){
                paso=false;
            }else{
                paso=false;
            }
        }

        return paso;
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
