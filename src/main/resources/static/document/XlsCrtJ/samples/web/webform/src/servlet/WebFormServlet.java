package servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CreateExcelFile;
import model.SampleWork;

public class WebFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public WebFormServlet() {
        super();
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/webformsample.jsp");
		requestDispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// 指定した環境変数から一時ディレクトリを取得
		String outputFilePath = SampleWork.getFileOutputDirectory();
		if (outputFilePath == null) {
			SampleWork.writeDescription(response,"一時ディレクトリの取得に失敗しました。<br>SampleWork.getFileOutputDirectory メソッド内の環境変数を調整してください");
			return;
		}

		// 日付をキーとしたファイル名を生成
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("'output'_yyyyMMdd_HHmmss'.xlsx'");
		outputFilePath += simpleDateFormat.format(new Date(System.currentTimeMillis()));

		// テンプレートファイルパスの取得
		ServletContext context = this.getServletContext();
		String templateFilePath = context.getRealPath("/WEB-INF/templatetotalinvoice.xlsx");

		// Excelファイル生成
		CreateExcelFile createExcelFile = new CreateExcelFile();
		createExcelFile.setName(request.getParameter("textBoxName"));
		createExcelFile.setAddress(request.getParameter("textBoxAddress"));
		createExcelFile.setNyukin(request.getParameter("textBoxNyukin"));
		createExcelFile.setPost(request.getParameter("textBoxPost"));
		createExcelFile.setSeikyu(request.getParameter("textBoxSeikyu"));
		createExcelFile.setUriage(request.getParameter("textBoxUriage"));
		String result = createExcelFile.createFile(outputFilePath, templateFilePath);
		if (result != null & "".equals(result) == false) {
			SampleWork.writeDescription(response, result);
			return;
		}

		// 生成ファイルをクライアントに転送
		SampleWork.executeFileTrasfer(response, outputFilePath);
	}

}
