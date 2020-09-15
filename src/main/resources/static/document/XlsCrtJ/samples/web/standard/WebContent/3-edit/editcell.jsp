<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
	<!-- ヘッダ -->
	<script type="text/javascript">
		header("<%=request.getContextPath()%>/donotedit/", "ecjava_sampleheader.png");
	</script>
	<form id="form1" action="<%=request.getContextPath()%>/EditCellServlet" method="post">
		<!-- Contents Main -->
		<div class="column-contents">
			<!-- Contents Right -->
			<div class="column-contents-1">
				<article class="article">
					<!-- タイトル -->
					<h1>ExcelCreator for Java - JavaEE Sample</h1>
					<h2>
						<i class="fa fa-chevron-right"></i>セル操作
					</h2>
					<p>ExcelCreator の機能でセルに対する操作を行います。</p>
					<div id="editcell1"></div>
					<p>
						<i class="fa fa-square"></i>セル範囲、オフセット指定
					</p>
					<p>
						"A1 参照形式"、"座標形式"、"セルの名前"、"変数名" によるセル指定方法以外に、セル範囲、セル位置のオフセット指定に対応します。基本的なセル指定方法は<a href="<%=request.getContextPath()%>/2-setvalue/cellpos.jsp">こちら</a>をご参照ください。
					</p>
					<p>
						<input type="submit" name="editcell1" value="Excel ファイル作成" style="width: 150px;" />
					</p>
					<hr />
					<div id="editcell2"></div>
					<p>
						<i class="fa fa-square"></i>値の設定、取得
					</p>
					<p>さまざまなデータ型による値の設定、値の取得に対応します。</p>
					<p>
						<input type="submit" name="editcell2" value="Excel ファイル作成" style="width: 150px;" />
					</p>
					<hr />
					<div id="editcell3"></div>
					<p>
						<i class="fa fa-square"></i>日付の設定、取得
					</p>
					<p>Excel の日付は Double 型のシリアル値で管理されているため、開発言語のデータ変換関数を用いて日付の設定、取得を行います。</p>
					<p>
						<input type="submit" name="editcell3" value="Excel ファイル作成" style="width: 150px;" />
					</p>
					<hr />
					<div id="editcell4"></div>
					<p>
						<i class="fa fa-square"></i>セルの操作
					</p>
					<p>セルのコピー・貼り付け、クリアを行います。</p>
					<p>
						<input type="submit" name="templateopen" value="テンプレートを確認" style="width: 150px;" />
					</p>
					<p>
						<input type="submit" name="editcell4" value="Excel ファイル作成" style="width: 150px;" />
					</p>
					<hr />
					<div id="editcell5"></div>
					<p>
						<i class="fa fa-square"></i>改ページの挿入
					</p>
					<p>セルや行列を指定して改ページの挿入を行います。</p>
					<p>
						<input type="submit" name="editcell5" value="Excel ファイル作成" style="width: 150px;" />
					</p>
					<p class="annotation1">※サンプルコードは「src/servlet/EditCellServlet.java」を参照してください。</p>
					<p class="annotation1">※ファイルはサーバーの[<%=model.SampleWork.getFileOutputDirectory()%>]に生成されます。</p>
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