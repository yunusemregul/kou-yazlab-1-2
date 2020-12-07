package arayuz;

import mantik.AVM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Arayuz
{
	private final int width = 1366;
	private final int height = 768;

	private final JPanel panel;

	public Arayuz()
	{
		JFrame frame = new JFrame();
		frame.setTitle("Yazlab 1 - 2");
		frame.setSize(width, height);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(66, 66, 66));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel()
		{
			@Override
			protected void paintComponent(Graphics g)
			{
				super.paintComponent(g);

				Graphics2D g2d = (Graphics2D) g;
				g2d.setStroke(new BasicStroke(2));
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				draw(g2d);
			}
		};

		panel.setOpaque(false);
		frame.add(panel);

		frame.setVisible(true);

		Timer cizimGuncelleme = new Timer(50, new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				panel.repaint();
			}
		});

		cizimGuncelleme.start();
	}

	private final int asansorGenislik = 130;
	private final int asansorUzunluk = 190;

	private void draw(Graphics2D g)
	{
		for (int i = 0; i < AVM.asansorler.length; i++)
		{
			int asansorX, asansorY;

			asansorX = i * (asansorGenislik + 5);
			asansorY = 0;

			if (AVM.asansorler[i].calisiyor)
			{
				g.setColor(Color.GREEN);
			}
			else
			{
				g.setColor(Color.red);
			}
			g.drawRect(asansorX, asansorY, asansorGenislik,asansorUzunluk);

			g.setColor(Color.WHITE);
			g.drawString(String.format("Calisiyor: %s", AVM.asansorler[i].calisiyor ? "evet" : "hayir"), asansorX, asansorY + 20);
			g.drawString(String.format("Oldugu kat: %d", AVM.asansorler[i].olduguKat), asansorX, asansorY + 40);
			g.drawString(String.format("Hedef kat: %d", AVM.asansorler[i].hedefKat), asansorX, asansorY + 60);
			g.drawString(String.format("Yon: %s", AVM.asansorler[i].hedefKat == 4 ? "yukari" : "asagi"), asansorX, asansorY + 80);
			g.drawString(String.format("Icindeki kisi sayisi: %d", AVM.asansorler[i].getMusteriler().size()), asansorX, asansorY + 100);
		}

		for (int i = 0; i < AVM.katlar.length; i++)
		{
			g.drawString(String.format("AVM %d kattaki kişi sayısı: %d, çıkacak kişi sayısı: %d", i, AVM.katlar[i].getMusteriler().size(), AVM.katlar[i].getMusteriler().stream().filter(musteri -> musteri.cikiyormu).count()), 5, asansorUzunluk + 25 + 20*i);
		}
	}
}
