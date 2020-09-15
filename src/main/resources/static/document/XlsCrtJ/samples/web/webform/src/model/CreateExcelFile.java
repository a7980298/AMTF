package model;

import java.util.Date;

import jp.co.adv.excelcreator.creator.XlsxCreator;
import jp.co.adv.excelcreator.enums.ErrorNo;

public class CreateExcelFile {

	String templateFile = null;
	String outputFile = null;
	String address = "";	// 住所
	String name = "";		// 請求先
	int post = 0;			// 郵便番号
	int seikyu = 0;			// 前回請求額
	int uriage = 0;			// 売上額
	int nyukin = 0;			// 入金額


	public void setAddress(String address) {
		this.address = address;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPost(String post) {
		this.post = parseInt(post);
	}
	public void setSeikyu(String seikyu) {
		this.seikyu = parseInt(seikyu);
	}
	public void setUriage(String uriage) {
		this.uriage = parseInt(uriage);
	}
	public void setNyukin(String nyukin) {
		this.nyukin = parseInt(nyukin);
	}
	public CreateExcelFile() {

	}

	public String createFile(String outputFile,String templateFile) {
		String errorMessage = null;
		try {
			XlsxCreator xlsxCreator = new XlsxCreator();
			xlsxCreator.openBook(outputFile, templateFile);
			if (xlsxCreator.getErrorNo() == ErrorNo.NoError) {
				// 現在時刻のシリアル値を取得
				Date date = new Date();
				// 86400000d = 1 日のミリ秒数(60s * 60m * 24h * 1000ms)
				// 25569d = Java と Excel の基準日の違いによる日数差
				// 0.375d = Java(GMT) と Excel(JST) の標準時の仕様の差異による時刻差(9 時間)
				double time = date.getTime() / 86400000d + 25569d + 0.375d;
				xlsxCreator.getCell("**DATE").setValue(time);
				xlsxCreator.getCell("**NO").setValue("ADV001");
				xlsxCreator.getCell("**POST").setValue(post);
				xlsxCreator.getCell("**ADDRESS").setValue(address);
				xlsxCreator.getCell("**USERNAME").setValue(name);
				xlsxCreator.getCell("**NYUKIN").setValue(nyukin);
				xlsxCreator.getCell("**ZENKAI").setValue(seikyu);
				xlsxCreator.getCell("**URIAGE").setValue(uriage);
				xlsxCreator.getCell("**KURIKOSI").setFunc("=C16-B16", seikyu - nyukin);
				xlsxCreator.getCell("**ZEI").setFunc("=E16*0.05", uriage * 0.05);
				xlsxCreator.getCell("**TOTAL").setFunc("=(C16-B16)+(E16*1.05)", (seikyu - nyukin) + (uriage * 1.05));
				xlsxCreator.getCell("**BIKO").setValue("お振込は翌月の 30 日までにお願いします。");
				xlsxCreator.closeBook(true);
				if (xlsxCreator.getErrorNo() != ErrorNo.NoError) {
					errorMessage = xlsxCreator.getErrorMessage();
				}
			}
			else {
				errorMessage = xlsxCreator.getErrorMessage();
				xlsxCreator.closeBook(false);
			}
		}
		catch (Exception e) {
			errorMessage = e.getMessage() + e.getStackTrace().toString();
		}
		return errorMessage;
	}

	private int parseInt(String value) {
		int res = 0;
		try {
			res = Integer.parseInt(value);
		}
		catch (Exception exception)
		{ }
		return res;
	}

}
