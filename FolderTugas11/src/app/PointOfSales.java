package app;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.print.PrinterException;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class PointOfSales extends JFrame {
    private static final long serialVersionUID = 1L;
    private static final Locale ID_LOCALE = Locale.forLanguageTag("id-ID");

    private final DefaultTableModel productTableModel;
    private final DefaultTableModel cartTableModel;
    private final JTable productTable;
    private final JTable cartTable;
    private final JLabel selectedProductLabel;
    private final JSpinner qtySpinner;
    private final JLabel totalLabel;
    private final JLabel pointsLabel;
    private final JTextArea receiptArea;

    public PointOfSales() {
        super("POIN Off-Sales - Java Swing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        setPreferredSize(new Dimension(1100, 600));

        setJMenuBar(createMenuBar());

        productTableModel = createProductTableModel();
        cartTableModel = createCartTableModel();

        productTable = new JTable(productTableModel);
        productTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        productTable.setDefaultEditor(Object.class, null);
        productTable.setFillsViewportHeight(true);
        productTable.getColumnModel().getColumn(0).setPreferredWidth(60);
        productTable.getColumnModel().getColumn(1).setPreferredWidth(180);
        productTable.getColumnModel().getColumn(2).setPreferredWidth(120);
        setCurrencyRenderer(productTable, 2);

        cartTable = new JTable(cartTableModel);
        cartTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        cartTable.setDefaultEditor(Object.class, null);
        cartTable.setFillsViewportHeight(true);
        cartTable.getColumnModel().getColumn(0).setPreferredWidth(60);
        cartTable.getColumnModel().getColumn(1).setPreferredWidth(180);
        cartTable.getColumnModel().getColumn(2).setPreferredWidth(60);
        cartTable.getColumnModel().getColumn(3).setPreferredWidth(100);
        cartTable.getColumnModel().getColumn(4).setPreferredWidth(120);
        setCurrencyRenderer(cartTable, 3);
        setCurrencyRenderer(cartTable, 4);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Produk", new JScrollPane(productTable));
        tabbedPane.addTab("Keranjang", new JScrollPane(cartTable));
        add(tabbedPane, BorderLayout.CENTER);

        selectedProductLabel = new JLabel("Pilih produk dari tabel di kiri");
        qtySpinner = new JSpinner(new SpinnerNumberModel(1, 1, 999, 1));
        totalLabel = new JLabel("Total: Rp0,00");
        pointsLabel = new JLabel("Points: 0");

        receiptArea = new JTextArea(24, 30);
        receiptArea.setEditable(false);
        receiptArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        receiptArea.setLineWrap(true);
        receiptArea.setWrapStyleWord(true);

        add(createControlPanel(), BorderLayout.SOUTH);
        add(createReceiptPanel(), BorderLayout.EAST);

        installListeners();

        pack();
        setLocationRelativeTo(null);
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> dispose());
        fileMenu.add(exitItem);

        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.addActionListener(e -> JOptionPane.showMessageDialog(this,
                "Point of Sales demo using Java Swing",
                "About",
                JOptionPane.INFORMATION_MESSAGE));
        helpMenu.add(aboutItem);

        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        return menuBar;
    }

    private DefaultTableModel createProductTableModel() {
        return new DefaultTableModel(new Object[][] {
                { "P001", "Air Mineral", 3000.0 },
                { "P002", "Kopi Sachet", 5000.0 },
                { "P003", "Roti isi", 8000.0 },
                { "P004", "Snack Keripik", 6000.0 },
                { "P005", "Minuman Botol", 12000.0 }
        }, new Object[] { "ID", "Nama Produk", "Harga (Rp)" }) {
            private static final long serialVersionUID = 1L;

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 2) {
                    return Double.class;
                }
                return String.class;
            }
        };
    }

    private DefaultTableModel createCartTableModel() {
        return new DefaultTableModel(new Object[] { "ID", "Nama Produk", "Qty", "Harga", "Subtotal" }, 0) {
            private static final long serialVersionUID = 1L;

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                switch (columnIndex) {
                    case 2:
                        return Integer.class;
                    case 3:
                    case 4:
                        return Double.class;
                    default:
                        return String.class;
                }
            }
        };
    }

    private JPanel createControlPanel() {
        JPanel controlPanel = new JPanel(new BorderLayout(15, 0));
        controlPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Input"));
        inputPanel.add(selectedProductLabel);
        inputPanel.add(Box.createVerticalStrut(10));

        JPanel qtyPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        qtyPanel.add(new JLabel("Qty:"));
        qtySpinner.setPreferredSize(new Dimension(60, qtySpinner.getPreferredSize().height));
        qtyPanel.add(qtySpinner);
        inputPanel.add(qtyPanel);
        inputPanel.add(Box.createVerticalStrut(10));

        JButton addToCartButton = new JButton("Add to Cart");
        addToCartButton.addActionListener(e -> addSelectedProductToCart());
        inputPanel.add(addToCartButton);

        JPanel totalsPanel = new JPanel();
        totalsPanel.setLayout(new BoxLayout(totalsPanel, BoxLayout.Y_AXIS));
        totalsPanel.setBorder(BorderFactory.createTitledBorder("Ringkasan"));
        totalsPanel.add(totalLabel);
        totalsPanel.add(Box.createVerticalStrut(8));
        totalsPanel.add(pointsLabel);
        totalsPanel.add(Box.createVerticalStrut(12));

        JButton checkoutButton = new JButton("Checkout");
        checkoutButton.addActionListener(e -> performCheckout());
        totalsPanel.add(checkoutButton);
        totalsPanel.add(Box.createVerticalStrut(8));

        JButton printButton = new JButton("Cetak");
        printButton.addActionListener(e -> printReceipt());
        totalsPanel.add(printButton);

        controlPanel.add(inputPanel, BorderLayout.WEST);
        controlPanel.add(totalsPanel, BorderLayout.EAST);
        return controlPanel;
    }

    private JPanel createReceiptPanel() {
        JPanel receiptPanel = new JPanel(new BorderLayout(5, 5));
        receiptPanel.setBorder(new EmptyBorder(10, 0, 10, 10));

        JLabel receiptLabel = new JLabel("Struk:");
        receiptPanel.add(receiptLabel, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(receiptArea);
        receiptPanel.add(scrollPane, BorderLayout.CENTER);
        return receiptPanel;
    }

    private void installListeners() {
        productTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                updateSelectedProductLabel();
            }
        });
    }

    private void updateSelectedProductLabel() {
        int selectedRow = productTable.getSelectedRow();
        if (selectedRow >= 0) {
            int modelRow = productTable.convertRowIndexToModel(selectedRow);
            String id = (String) productTableModel.getValueAt(modelRow, 0);
            String name = (String) productTableModel.getValueAt(modelRow, 1);
            double price = ((Number) productTableModel.getValueAt(modelRow, 2)).doubleValue();
            selectedProductLabel.setText("Dipilih: " + id + " - " + name + " (" + formatCurrency(price) + ")");
        } else {
            selectedProductLabel.setText("Pilih produk dari tabel di kiri");
        }
    }

    private void addSelectedProductToCart() {
        int selectedRow = productTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Harap pilih produk terlebih dahulu.", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        int modelRow = productTable.convertRowIndexToModel(selectedRow);
        String id = (String) productTableModel.getValueAt(modelRow, 0);
        String name = (String) productTableModel.getValueAt(modelRow, 1);
        double price = ((Number) productTableModel.getValueAt(modelRow, 2)).doubleValue();
        int quantity = (Integer) qtySpinner.getValue();

        double subtotal = price * quantity;
        cartTableModel.addRow(new Object[] { id, name, quantity, price, subtotal });
        updateTotals();
        qtySpinner.setValue(1);
    }

    private void updateTotals() {
        double total = calculateTotal();
        totalLabel.setText("Total: " + formatCurrency(total));
        int points = (int) (total / 1000);
        pointsLabel.setText("Points: " + points);
    }

    private double calculateTotal() {
        double total = 0.0;
        for (int i = 0; i < cartTableModel.getRowCount(); i++) {
            total += ((Number) cartTableModel.getValueAt(i, 4)).doubleValue();
        }
        return total;
    }

    private void performCheckout() {
        if (cartTableModel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Keranjang masih kosong.", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        double total = calculateTotal();
        int points = (int) (total / 1000);

        StringBuilder builder = new StringBuilder();
        builder.append("==== Struk Belanja ====")
               .append(System.lineSeparator());
        builder.append("Waktu : ")
               .append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")))
               .append(System.lineSeparator())
               .append(System.lineSeparator());
        builder.append(String.format("%-6s %-18s %5s %12s %12s%n", "ID", "Produk", "Qty", "Harga", "Subtotal"));
        builder.append("------------------------------------------------------------")
               .append(System.lineSeparator());

        for (int i = 0; i < cartTableModel.getRowCount(); i++) {
            String id = (String) cartTableModel.getValueAt(i, 0);
            String name = (String) cartTableModel.getValueAt(i, 1);
            int quantity = ((Number) cartTableModel.getValueAt(i, 2)).intValue();
            double price = ((Number) cartTableModel.getValueAt(i, 3)).doubleValue();
            double subtotal = ((Number) cartTableModel.getValueAt(i, 4)).doubleValue();
            builder.append(String.format("%-6s %-18s %5d %12s %12s%n",
                    id,
                    name,
                    quantity,
                    formatCurrency(price),
                    formatCurrency(subtotal)));
        }

        builder.append("------------------------------------------------------------")
               .append(System.lineSeparator());
        builder.append(String.format("Total   : %s%n", formatCurrency(total)));
        builder.append(String.format("Poin    : %d%n", points));
        builder.append("Terima kasih telah berbelanja!");

        receiptArea.setText(builder.toString());
        cartTableModel.setRowCount(0);
        updateTotals();
    }

    private void printReceipt() {
        if (receiptArea.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Belum ada struk untuk dicetak.", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        try {
            boolean completed = receiptArea.print();
            if (!completed) {
                JOptionPane.showMessageDialog(this, "Pencetakan dibatalkan.", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (PrinterException ex) {
            JOptionPane.showMessageDialog(this, "Gagal mencetak: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setCurrencyRenderer(JTable table, int columnIndex) {
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
            private static final long serialVersionUID = 1L;

            @Override
            protected void setValue(Object value) {
                if (value instanceof Number) {
                    setText(formatCurrency(((Number) value).doubleValue()));
                } else {
                    super.setValue(value);
                }
            }
        };
        renderer.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
        table.getColumnModel().getColumn(columnIndex).setCellRenderer(renderer);
    }

    private String formatCurrency(double amount) {
        NumberFormat format = NumberFormat.getCurrencyInstance(ID_LOCALE);
        return format.format(amount);
    }

    private static void applySystemLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            // Ignore and keep default look and feel.
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            applySystemLookAndFeel();
            new PointOfSales().setVisible(true);
        });
    }
}
