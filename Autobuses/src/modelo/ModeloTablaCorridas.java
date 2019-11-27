package modelo;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;







public class ModeloTablaCorridas
  extends AbstractTableModel
{
  private ArrayList<Corridas> datos;
  private String[] encabezado;
  
  public ModeloTablaCorridas(ArrayList<Corridas> corridas, String[] nomColumnas) {
    this.datos = corridas;
    this.encabezado = nomColumnas;
  }

  
  public String getColumnName(int i) { return this.encabezado[i]; }
  public Object getValueAt(int r, int c) {
    DateFormat formatoHora;
    DateFormat formatoFecha;
    switch (c) {
      case 0:
        return Integer.valueOf(((Corridas)this.datos.get(r)).getNumCorridas());
      case 1: return ((Corridas)this.datos.get(r)).getOrigen();
      case 2: return ((Corridas)this.datos.get(r)).getDestino();
      case 3: formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        return formatoFecha.format(((Corridas)this.datos.get(r)).getFecha());
      case 4: formatoHora = new SimpleDateFormat("HH:mm");
        return formatoHora.format(((Corridas)this.datos.get(r)).getFecha());
      case 5: return ((Corridas)this.datos.get(r)).getClaseAutobus();
      case 6: return ((Corridas)this.datos.get(r)).getPrecio();
     
    }  
    return ((Corridas)this.datos.get(r)).getLugares();
  }




  
  public int getRowCount() { return this.datos.size(); }



  
  public int getColumnCount() { return this.encabezado.length; }
}
