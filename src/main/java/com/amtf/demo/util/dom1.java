package com.amtf.demo.util;

import java.awt.Robot;
import java.awt.event.KeyEvent;

public class dom1 {
	public static void main(String[] args) {
		while (true) {
			try {
				// 控制键盘
				Robot rpbot = new Robot();
				// 按下
				rpbot.keyPress(KeyEvent.VK_CAPS_LOCK);
				// 释放
				rpbot.keyRelease(KeyEvent.VK_CAPS_LOCK);
				Thread.currentThread();
				// 等待
				Thread.sleep(60000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
