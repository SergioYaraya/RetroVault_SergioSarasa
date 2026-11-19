/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Juego;

/**
 *
 * @author 2DAM
 */
public class JuegosTableModel extends AbstractTableModel{
    private static final String[] COLS = {"#", "Título", "Consola", "Género", "Año", "Puntuación", "Estado"};

    private List<Juego> juegos;

    public JuegosTableModel(List<Juego> juegos) {
        this.juegos = juegos;
    }

    public void setJuegos(List<Juego> juegos) {
        this.juegos = juegos;
        fireTableDataChanged();
    }

    public Juego getJuego(int fila) {
        return juegos.get(fila);
    }

    @Override
    public int getRowCount() {
        return juegos.size();
    }

    @Override
    public int getColumnCount() {
        return COLS.length;
    }

    @Override
    public String getColumnName(int col) {
        return COLS[col];
    }

    @Override
    public Object getValueAt(int fila, int col) {

        Juego j = juegos.get(fila);

        switch (col) {
            case 0:
                return j.getId();

            case 1:
                return j.getTitulo();

            case 2:
                return j.getConsola();

            case 3:
                return j.getGenero();

            case 4:
                return j.getAnio();

            case 5:
                return j.getPuntuacion() == 0
                        ? "—"
                        : "★".repeat(j.getPuntuacion());

            case 6:
                return j.getEstado();

            default:
                return "";
        }
    }

    @Override
    public boolean isCellEditable(int fila, int col) {
        return false;
    }
}
