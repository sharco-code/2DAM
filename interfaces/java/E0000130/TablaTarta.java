import javax.swing.JFrame;
import org.jfree.chart.*;
import org.jfree.data.category.*;
import org.jfree.data.general.DefaultPieDataset;


public class TablaTarta extends JFrame {
    
    TablaTarta(String Title) {
        
        JFreeChart pieChart = ChartFactory.createPieChart(Title, data());
         
        ChartPanel chartPanel = new ChartPanel(pieChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 400));
        setContentPane(chartPanel);
    }

    private DefaultPieDataset data() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Dato 1", 30);
        dataset.setValue("Dato 2", 40);
        dataset.setValue("Dato 3", 30);
        return dataset;
    }
    
    
    public static void main(String[] args) {
    	TablaTarta main = new TablaTarta("Datos");
        main.pack();
        main.setVisible(true);
        main.setLocationRelativeTo(null);
        main.setResizable(false);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}