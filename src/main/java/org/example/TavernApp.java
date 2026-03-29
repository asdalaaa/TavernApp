package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class TavernApp extends JFrame {

    @FunctionalInterface
    interface Factory { Dish create(Dish base); }

    private final Map<String, Factory> MODS = new LinkedHashMap<>();
    private final Map<String, JCheckBox> boxes = new LinkedHashMap<>();
    private final JTextArea area = new JTextArea(10, 20);
    private final JLabel priceLabel = new JLabel();

    public TavernApp() {
        super("Таверна");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 400);
        setLayout(new FlowLayout());

        MODS.put("Соус (+40)", FireSauce::new);
        MODS.put("Оленина (+20)", DoubleVenison::new);
        MODS.put("Ягоды (+6)", SnowBerries::new);
        MODS.put("Лепёшка (+7)", NordicFlatbread::new);

        JPanel choicePanel = new JPanel();
        choicePanel.setLayout(new BoxLayout(choicePanel, BoxLayout.Y_AXIS));

        for (String name : MODS.keySet()) {
            JCheckBox cb = new JCheckBox(name);
            cb.addActionListener(e -> updateUIState());
            boxes.put(name, cb);
            choicePanel.add(cb);
        }

        JButton btn = new JButton("Заказать");
        btn.addActionListener(e -> placeOrder());

        add(choicePanel);
        add(new JScrollPane(area));
        add(priceLabel);
        add(btn);

        updateUIState();
        setLocationRelativeTo(null);
    }

    private Dish buildCurrentDish() {
        Dish dish = new NordicStew();
        for (String name : boxes.keySet()) {
            if (boxes.get(name).isSelected()) {
                dish = MODS.get(name).create(dish);
            }
        }
        return dish;
    }

    private void updateUIState() {
        int count = 0;
        for (JCheckBox cb : boxes.values()) {
            if (cb.isSelected()) {
                count++;
            }
        }

        for (JCheckBox cb : boxes.values()) {
            if (cb.isSelected()) {
                cb.setEnabled(true);
            } else {
                cb.setEnabled(count < 3);
            }
        }

        priceLabel.setText("Итого: " + buildCurrentDish().getPrice() + " септ.");
    }


    private void placeOrder() {
        Dish dish = buildCurrentDish();
        area.append(dish.getName() + " " + dish.getPrice() + " септ.\n");

        for (JCheckBox cb : boxes.values()) {
            cb.setSelected(false);
        }

        updateUIState();
    }

}