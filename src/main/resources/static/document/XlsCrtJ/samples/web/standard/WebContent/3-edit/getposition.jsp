<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.SampleWork"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<title>ExcelCreator for Java - JavaEE サンプル</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width">
<meta name="author" content="アドバンスソフトウェア株式会社">
<meta name="copyright" content="アドバンスソフトウェア株式会社">
<link rel="shortcut icon" href="<%=request.getContextPath()%>/donotedit/images/ecjava1_sampleicon.ico" type="image/vnd.microsoft.icon">
<!--[if lt IE 9]>
	<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
<!-- jQuery UI -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/donotedit/css/style.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/donotedit/font-awesome-4.3.0/css/font-awesome.min.css">
<link type="text/css" href="<%=request.getContextPath()%>/donotedit/scripts/jquery-ui.css" rel="stylesheet">
<script type="text/javascript" src="<%=request.getContextPath()%>/donotedit/scripts/jquery-ui.min.js"></script>
<!-- ヘッダ、フッタ共通化 -->
<script type="text/javascript" src="<%=request.getContextPath()%>/donotedit/scripts/header.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/donotedit/scripts/footer.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/donotedit/scripts/footerfixed.js"></script>
</head>
<body>
	<%
		SampleWork sampleWork = null;
		sampleWork = (SampleWork)request.getAttribute("samplework");

		String resulttext1 = null;
		String resulttext2 = null;
		if (sampleWork != null)
		{
			resulttext1 = sampleWork.getRefText(0);
			resulttext2 = sampleWork.getRefText(1);
		}
		if (resulttext1 == null)
			resulttext1 = "";
		if (resulttext2 == null)
			resulttext2 = "";
	%>
	<!-- ヘッダ -->
	<script type="text/javascript">
		header("<%=request.getContextPath()%>/donotedit/", "ecjava_sampleheader.png");
	</script>
	<form id="form1" action="<%=request.getContextPath()%>/GetPositionServlet" method="post">
		<!-- Contents Main -->
		<div class="column-contents">
			<!-- Contents Right -->
			<div class="column-contents-1">
				<article class="article">
					<!-- タイトル -->
					<h1>ExcelCreator for Java - JavaEE Sample</h1>
					<h2>
						<i class="fa fa-chevron-right"></i>座標情報の取得
					</h2>
					<p>ExcelCreator の機能でシート内の座標情報を取得します。</p>
					<p>
						<i class="fa fa-square"></i>座標情報の取得（変数名、セル名）
					</p>
					<p>
						指定した変数名、セル名の座標情報の取得を行います。<br />同一の変数名が複数配置されている場合、第 2 引数に取得したい変数名の番号(A1 セルに近い順 0～)を指定します。
					</p>
					<p>
						<input type="submit" name="templateopen1" value="テンプレートを確認" style="width: 150px;" />
					</p>
					<p>
						<select name="verposition" size="1" style="width: 50px">
							<option value="0">0</option>
							<option value="1">1</option>
							<option value="2">2</option>
						</select><label>番目の変数名「**Var」の座標取得</label>
					</p>
					<p>
						<input type="submit" name="getposver" value="座標取得（変数名）" style="width: 150px;" />
					</p>
					<p>セル名「NAMAE」の座標取得</p>
					<p>
						<input type="submit" name="getposcellname" value="座標取得（セル名）" style="width: 150px;" />
					</p>
					<div id="result1"></div>
					<p>
						<label style="margin-right: 15px">取得結果</label><input type="text" name="resulttext1" size="20" style="width: 80%" value="<%=resulttext1%>" readonly />
					</p>
					<hr />
					<div id="data"></div>
					<p>
						<i class="fa fa-square"></i>データの最終座標の取得
					</p>
					<p>
						Excel シート上で値、または、書式が設定されているセルの最終座標の取得を行います。<br />getMaxData メソッドは値を、getMaxArea メソッドは書式を対象とします。
					</p>
					<p>
						<input type="submit" name="templateopen2" value="テンプレートを確認" style="width: 150px;" />
					</p>
					<p>
						<input type="radio" name="point" id="r1" value="end" checked="checked" /><label for="r1">EndPoint－データのある１番右下の座標</label><br /> <input type="radio" name="point" id="r2" value="max" /><label for="r2">MaxPoint－最大行と最大列の交点</label>
					</p>
					<p>
						<input type="submit" name="getmaxdata" value="getMaxData" style="width: 150px;" />
					</p>
					<p>
						<input type="submit" name="getmaxarea" value="getMaxArea" style="width: 150px;" />
					</p>
					<div id="result2"></div>
					<p>
						<label style="margin-right: 15px">取得結果</label><input type="text" name="resulttext2" size="20" style="width: 80%" value="<%=resulttext2%>" readonly />
					</p>
					<p class="annotation1">※サンプルコードは「src/servlet/GetPositionServlet.java」を参照してください。</p>
					<p class="annotation1">Javaバージョン：<%=System.getProperty("java.version")%></p>
				</article>
			</div>
			<!-- サイドメニュー -->
			<div class="column-contents-2">
				<aside class="sidemenu">
					<h2>Menu</h2>
					<ul class="tree-menu">
						<li><a href="<%=request.getContextPath()%>/index.html">Top</a>
							<ul class="tree-menu-main" id="jquery-menu-1-sub">
								<li><i class="fa fa-square"></i>ファイル作成
									<ul class="jquery-menu-sub" id="jquery-menu-1-1-sub">
										<li><a href="<%=request.getContextPath()%>/1-file/createbook.jsp"><i class="fa fa-chevron-right"></i>新規作成</a></li>
										<li><a href="<%=request.getContextPath()%>/1-file/overlay.jsp"><i class="fa fa-chevron-right"></i>オーバーレイ/上書きオープン</a></li>
										<li><a href="<%=request.getContextPath()%>/1-file/pdf.jsp"><i class="fa fa-chevron-right"></i>PDF 出力</a></li>
										<li><a href="<%=request.getContextPath()%>/1-file/pdfoption1.jsp"><i class="fa fa-chevron-right"></i>PDF オプション 1</a></li>
										<li><a href="<%=request.getContextPath()%>/1-file/pdfoption2.jsp"><i class="fa fa-chevron-right"></i>PDF オプション 2</a></li>
										<li><a href="<%=request.getContextPath()%>/1-file/html.jsp"><i class="fa fa-chevron-right"></i>HTML 出力</a></li>
										<li><a href="<%=request.getContextPath()%>/1-file/htmloption.jsp"><i class="fa fa-chevron-right"></i>HTML オプション</a></li>
									</ul></li>
								<li><i class="fa fa-square"></i>値の設定（基本操作）
									<ul class="jquery-menu-sub" id="jquery-menu-1-2-sub">
										<li><a href="<%=request.getContextPath()%>/2-setvalue/cellpos.jsp"><i class="fa fa-chevron-right"></i>セルの指定方法</a></li>
										<li><a href="<%=request.getContextPath()%>/2-setvalue/hensuu.jsp"><i class="fa fa-chevron-right"></i>変数名の使用例</a></li>
									</ul></li>
								<li><i class="fa fa-square"></i>Excel 操作・編集
									<ul class="jquery-menu-sub" id="jquery-menu-1-3-sub">
										<li><a href="<%=request.getContextPath()%>/3-edit/attributesheet.jsp"><i class="fa fa-chevron-right"></i>シート操作</a></li>
										<li><a href="<%=request.getContextPath()%>/3-edit/attributerowcol.jsp"><i class="fa fa-chevron-right"></i>行列操作</a></li>
										<li><a href="<%=request.getContextPath()%>/3-edit/editcell.jsp"><i class="fa fa-chevron-right"></i>セル操作</a></li>
										<li><a href="<%=request.getContextPath()%>/3-edit/attributecell.jsp"><i class="fa fa-chevron-right"></i>セルの書式設定</a></li>
										<li><a href="<%=request.getContextPath()%>/3-edit/calculate.jsp"><i class="fa fa-chevron-right"></i>Excel 計算式</a></li>
										<li><a href="<%=request.getContextPath()%>/3-edit/drawing.jsp"><i class="fa fa-chevron-right"></i>図、シェイプの設定</a></li>
										<li><a href="<%=request.getContextPath()%>/3-edit/getposition.jsp"><i class="fa fa-chevron-right"></i>座標情報の取得</a></li>
									</ul></li>
							</ul></li>
					</ul>
				</aside>
			</div>
		</div>
		<!-- フッタ -->
		<script type="text/javascript">
			footer();
		</script>
	</form>

</body>
</html>