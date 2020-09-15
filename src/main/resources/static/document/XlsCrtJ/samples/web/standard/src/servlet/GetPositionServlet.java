package servlet;

import java.awt.Point;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.adv.excelcreator.creator.ErrorListener;
import jp.co.adv.excelcreator.creator.ExcelCreatorException;
import jp.co.adv.excelcreator.creator.XlsxCreator;
import jp.co.adv.excelcreator.enums.MaxEndPoint;
import model.SampleWork;


public class GetPositionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String result;
	private String fileName;
	private String outFileName;
	private String returnValue;

	public GetPositionServlet() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse  response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// 指定した環境変数から一時ディレクトリを取得
		outFileName = SampleWork.getFileOutputDirectory();
		if (outFileName == null) {
			SampleWork.writeDescription(response,"一時ディレクトリの取得に失敗しました。<br />SampleWork.getFileOutputDirectory メソッド内の環境変数を調整してください");
			return;
		}
		// テンプレートファイルパスの取得
		ServletContext context = this.getServletContext();
		// Excelファイル生成
		XlsxCreator xlsxCreator = new XlsxCreator();
		xlsxCreator.setKeyword("**");
		// Error イベント
		result = "";
		xlsxCreator.addErrorEvent(new ErrorListener(){
			@Override
			public void error(ExcelCreatorException e) {
				result += e.getErrorMessage() + "<br />";
			}
		}
				);

		// 座標情報の取得（変数名）
		if (request.getParameter("getposver") != null)
		{
			fileName = context.getRealPath("/WEB-INF/data/templateetc.xlsx");	// テンプレート Excel ファイル

			//【1】===========================================================//
			// Excel ファイル読み込み専用オープン
			//================================================================//
			xlsxCreator.readBook(fileName);

			//【2】===========================================================//
			// 座標情報の取得（変数名）
			//================================================================//
			Integer index = 0;
			try {
				index = Integer.parseInt(request.getParameter("verposition"));
			} catch (NumberFormatException ex) {
			}
			Point pt = xlsxCreator.getVarNamePos("**Var", index);   // 変数名が存在しない場合、{-1,-1}となります。
			//Boolean result = xlsxCreator.varCheck(varName);		// VarCheck メソッドで変数名の有無が確認可能。
			returnValue = String.format("変数名[**Var(%S番目)]の座標は x=[%s] y=[%s] です。", index, pt.x, pt.y);

			//【3】===========================================================//
			// Excel ファイルクローズ
			//================================================================//
			xlsxCreator.closeBook(true);

			if (result.equals("") == false) {
				SampleWork.writeDescription(response, result);
				return;
			}

			SampleWork sampleWork = new SampleWork();
			sampleWork.setRefText(returnValue, 0);
			request.setAttribute("samplework", sampleWork);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("3-edit/getposition.jsp");
			requestDispatcher.forward(request, response);
		}
		// 座標情報の取得（セル名）
		else if (request.getParameter("getposcellname") != null)
		{
			fileName = context.getRealPath("/WEB-INF/data/templateetc.xlsx");			// 上書き対象 Excel ファイル

			//【1】===========================================================//
			// Excel ファイル読み込み専用オープン
			//================================================================//
			xlsxCreator.readBook(fileName);

			//【2】===========================================================//
			// 座標情報の取得（セル名）
			//================================================================//
			Point pt = xlsxCreator.getNamePos("NAMAE");   // 変数名が存在しない場合、{-1,-1}となります。
			returnValue = String.format("セル名[NAMAE]の座標は x=[%d] y=[%d] です。", pt.x, pt.y);

			//【3】===========================================================//
			// Excel ファイルクローズ
			//================================================================//
			xlsxCreator.closeBook(true);

			if (result.equals("") == false) {
				SampleWork.writeDescription(response, result);
				return;
			}

			SampleWork sampleWork = new SampleWork();
			sampleWork.setRefText(returnValue, 0);
			request.setAttribute("samplework", sampleWork);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("3-edit/getposition.jsp");
			requestDispatcher.forward(request, response);
		}
		// データの最終座標の取得（セルの値）
		else if (request.getParameter("getmaxdata") != null)
		{
			fileName = context.getRealPath("/WEB-INF/data/templateetc.xlsx");			// 上書き対象 Excel ファイル

			//【1】===========================================================//
			// Excel ファイル読み込み専用オープン
			//================================================================//
			xlsxCreator.readBook(fileName);

			//【2】===========================================================//
			// データの最終座標の取得（セルの値）
			//================================================================//
			Point pt;
			// 最終座標の種別に EndPoint
			if (request.getParameter("point").equals("end") == true) {
				pt = xlsxCreator.getMaxData(MaxEndPoint.EndPoint);	// 一番下の行の最終データの座標
				//pt = xlsxCreator.getMaxData();					// 省略時は EndPointと同じ
			}
			// 最終座標の種別に MaxPoint
			else {
				pt = xlsxCreator.getMaxData(MaxEndPoint.MaxPoint);	// 列の最終座標と行の最終座標の交点
			}
			returnValue = String.format("セルの最終座標は x=[%d] y=[%d] です。", pt.x, pt.y);

			//【3】===========================================================//
			// Excel ファイルクローズ
			//================================================================//
			xlsxCreator.closeBook(true);

			if (result.equals("") == false) {
				SampleWork.writeDescription(response, result);
				return;
			}

			SampleWork sampleWork = new SampleWork();
			sampleWork.setRefText(returnValue, 1);
			request.setAttribute("samplework", sampleWork);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("3-edit/getposition.jsp");
			requestDispatcher.forward(request, response);
		}
		// データの最終座標の取得（セルの値、書式含む）
		else if (request.getParameter("getmaxarea") != null)
		{
			fileName = context.getRealPath("/WEB-INF/data/templateetc.xlsx");			// 上書き対象 Excel ファイル

			//【1】===========================================================//
			// Excel ファイル読み込み専用オープン
			//================================================================//
			xlsxCreator.readBook(fileName);

			//【2】===========================================================//
			// データの最終座標の取得（セルの値、書式含む）
			//================================================================//
			Point pt;
			// 最終座標の種別に EndPoint
			if (request.getParameter("point").equals("end") == true) {
				pt = xlsxCreator.getMaxArea(MaxEndPoint.EndPoint);	// 一番下の行の最終データの座標
				//pt = xlsxCreator.getMaxArea();					// 省略時は EndPointと同じ
			} // 最終座標の種別に MaxPoint
			else {
				pt = xlsxCreator.getMaxArea(MaxEndPoint.MaxPoint);	// 列の最終座標と行の最終座標の交点
			}
			returnValue = String.format("セルの最終座標は x=[%d] y=[%d] です。", pt.x, pt.y);

			//【3】===========================================================//
			// Excel ファイルクローズ
			//================================================================//
			xlsxCreator.closeBook(true);

			if (result.equals("") == false) {
				SampleWork.writeDescription(response, result);
				return;
			}

			SampleWork sampleWork = new SampleWork();
			sampleWork.setRefText(returnValue, 1);
			request.setAttribute("samplework", sampleWork);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("3-edit/getposition.jsp");
			requestDispatcher.forward(request, response);
		}
		// テンプレート Excel ファイルオープン
		else if (request.getParameter("templateopen1") != null)
		{
			fileName = context.getRealPath("/WEB-INF/data/templateetc.xlsx");
			SampleWork.executeFileTrasfer(response, fileName);
		}
		// テンプレート Excel ファイルオープン
		else if (request.getParameter("templateopen2") != null)
		{
			fileName = context.getRealPath("/WEB-INF/data/templateetc.xlsx");
			SampleWork.executeFileTrasfer(response, fileName);
		}
	}

}