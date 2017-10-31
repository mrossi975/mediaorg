package net.thorhammer.mediaorg;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MediaOrg {

    private JFrame frame;
    private JTextField textField;
    private JLabel lblTargetFolder;
    private JTextField textField_1;
    private JButton btnBrowse_1;
    private JLabel lblFfmpegInstallation;
    private JTextField textField_2;
    private JButton btnNewButton;
    private JLabel lblIncludePatternjava;
    private JTextField textField_3;
    private JButton btnFind;
    private JButton btnTest;
    private JLabel lblFilenameExcludePattern;
    private JTextField textField_4;
    private JLabel lblSidecarFileExtensions;
    private JTextField txtxmpaae;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    MediaOrg window = new MediaOrg();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public MediaOrg() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 794, 557);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0 };
        gridBagLayout.rowHeights = new int[] { 15, 0, 0, 15, 0, 0, 15, 0, 0, 0, 0, 15, 0, 0, 0, 15, 0, 0, 15, 0, 0, 0 };
        gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
        gridBagLayout.rowWeights = new double[] {
                0.0,
                0.0,
                0.0,
                0.0,
                0.0,
                0.0,
                0.0,
                0.0,
                0.0,
                0.0,
                0.0,
                0.0,
                0.0,
                0.0,
                0.0,
                0.0,
                0.0,
                0.0,
                0.0,
                0.0,
                0.0,
                Double.MIN_VALUE };
        frame.getContentPane().setLayout(gridBagLayout);

        JLabel lblSourceFolder = new JLabel("Source Folder");
        GridBagConstraints gbc_lblSourceFolder = new GridBagConstraints();
        gbc_lblSourceFolder.anchor = GridBagConstraints.WEST;
        gbc_lblSourceFolder.insets = new Insets(0, 0, 5, 5);
        gbc_lblSourceFolder.gridx = 2;
        gbc_lblSourceFolder.gridy = 1;
        frame.getContentPane().add(lblSourceFolder, gbc_lblSourceFolder);

        textField = new JTextField();
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.insets = new Insets(0, 0, 5, 5);
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridx = 2;
        gbc_textField.gridy = 2;
        frame.getContentPane().add(textField, gbc_textField);
        textField.setColumns(15);

        JButton btnBrowse = new JButton("Browse");
        GridBagConstraints gbc_btnBrowse = new GridBagConstraints();
        gbc_btnBrowse.insets = new Insets(0, 0, 5, 5);
        gbc_btnBrowse.gridx = 3;
        gbc_btnBrowse.gridy = 2;
        frame.getContentPane().add(btnBrowse, gbc_btnBrowse);

        lblTargetFolder = new JLabel("Target Folder");
        GridBagConstraints gbc_lblTargetFolder = new GridBagConstraints();
        gbc_lblTargetFolder.anchor = GridBagConstraints.WEST;
        gbc_lblTargetFolder.insets = new Insets(0, 0, 5, 5);
        gbc_lblTargetFolder.gridx = 2;
        gbc_lblTargetFolder.gridy = 3;
        frame.getContentPane().add(lblTargetFolder, gbc_lblTargetFolder);

        textField_1 = new JTextField();
        GridBagConstraints gbc_textField_1 = new GridBagConstraints();
        gbc_textField_1.insets = new Insets(0, 0, 5, 5);
        gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_1.gridx = 2;
        gbc_textField_1.gridy = 4;
        frame.getContentPane().add(textField_1, gbc_textField_1);
        textField_1.setColumns(15);

        btnBrowse_1 = new JButton("Browse");
        GridBagConstraints gbc_btnBrowse_1 = new GridBagConstraints();
        gbc_btnBrowse_1.insets = new Insets(0, 0, 5, 5);
        gbc_btnBrowse_1.gridx = 3;
        gbc_btnBrowse_1.gridy = 4;
        frame.getContentPane().add(btnBrowse_1, gbc_btnBrowse_1);

        lblFfmpegInstallation = new JLabel("FFMpeg Installation");
        GridBagConstraints gbc_lblFfmpegInstallation = new GridBagConstraints();
        gbc_lblFfmpegInstallation.anchor = GridBagConstraints.WEST;
        gbc_lblFfmpegInstallation.insets = new Insets(0, 0, 5, 5);
        gbc_lblFfmpegInstallation.gridx = 2;
        gbc_lblFfmpegInstallation.gridy = 5;
        frame.getContentPane().add(lblFfmpegInstallation, gbc_lblFfmpegInstallation);

        textField_2 = new JTextField();
        GridBagConstraints gbc_textField_2 = new GridBagConstraints();
        gbc_textField_2.insets = new Insets(0, 0, 5, 5);
        gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_2.gridx = 2;
        gbc_textField_2.gridy = 6;
        frame.getContentPane().add(textField_2, gbc_textField_2);
        textField_2.setColumns(15);

        btnNewButton = new JButton("Browse");
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
        gbc_btnNewButton.gridx = 3;
        gbc_btnNewButton.gridy = 6;
        frame.getContentPane().add(btnNewButton, gbc_btnNewButton);

        btnFind = new JButton("Find");
        GridBagConstraints gbc_btnFind = new GridBagConstraints();
        gbc_btnFind.insets = new Insets(0, 0, 5, 5);
        gbc_btnFind.gridx = 4;
        gbc_btnFind.gridy = 6;
        frame.getContentPane().add(btnFind, gbc_btnFind);

        lblSidecarFileExtensions = new JLabel("Sidecar File Extensions");
        GridBagConstraints gbc_lblSidecarFileExtensions = new GridBagConstraints();
        gbc_lblSidecarFileExtensions.anchor = GridBagConstraints.WEST;
        gbc_lblSidecarFileExtensions.insets = new Insets(0, 0, 5, 5);
        gbc_lblSidecarFileExtensions.gridx = 2;
        gbc_lblSidecarFileExtensions.gridy = 7;
        frame.getContentPane().add(lblSidecarFileExtensions, gbc_lblSidecarFileExtensions);

        txtxmpaae = new JTextField();
        txtxmpaae.setText("*.xmp, *.aae");
        GridBagConstraints gbc_txtxmpaae = new GridBagConstraints();
        gbc_txtxmpaae.insets = new Insets(0, 0, 5, 5);
        gbc_txtxmpaae.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtxmpaae.gridx = 2;
        gbc_txtxmpaae.gridy = 8;
        frame.getContentPane().add(txtxmpaae, gbc_txtxmpaae);
        txtxmpaae.setColumns(15);

        lblIncludePatternjava = new JLabel("Filename Include Pattern");
        GridBagConstraints gbc_lblIncludePatternjava = new GridBagConstraints();
        gbc_lblIncludePatternjava.anchor = GridBagConstraints.WEST;
        gbc_lblIncludePatternjava.insets = new Insets(0, 0, 5, 5);
        gbc_lblIncludePatternjava.gridx = 2;
        gbc_lblIncludePatternjava.gridy = 10;
        frame.getContentPane().add(lblIncludePatternjava, gbc_lblIncludePatternjava);

        lblFilenameExcludePattern = new JLabel("Filename Exclude Pattern");
        GridBagConstraints gbc_lblFilenameExcludePattern = new GridBagConstraints();
        gbc_lblFilenameExcludePattern.anchor = GridBagConstraints.WEST;
        gbc_lblFilenameExcludePattern.insets = new Insets(0, 0, 5, 5);
        gbc_lblFilenameExcludePattern.gridx = 3;
        gbc_lblFilenameExcludePattern.gridy = 10;
        frame.getContentPane().add(lblFilenameExcludePattern, gbc_lblFilenameExcludePattern);

        textField_3 = new JTextField();
        GridBagConstraints gbc_textField_3 = new GridBagConstraints();
        gbc_textField_3.insets = new Insets(0, 0, 5, 5);
        gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_3.gridx = 2;
        gbc_textField_3.gridy = 11;
        frame.getContentPane().add(textField_3, gbc_textField_3);
        textField_3.setColumns(15);

        textField_4 = new JTextField();
        GridBagConstraints gbc_textField_4 = new GridBagConstraints();
        gbc_textField_4.insets = new Insets(0, 0, 5, 5);
        gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_4.gridx = 3;
        gbc_textField_4.gridy = 11;
        frame.getContentPane().add(textField_4, gbc_textField_4);
        textField_4.setColumns(15);

        btnTest = new JButton("Test");
        GridBagConstraints gbc_btnTest = new GridBagConstraints();
        gbc_btnTest.insets = new Insets(0, 0, 5, 5);
        gbc_btnTest.gridx = 4;
        gbc_btnTest.gridy = 11;
        frame.getContentPane().add(btnTest, gbc_btnTest);
    }

}
