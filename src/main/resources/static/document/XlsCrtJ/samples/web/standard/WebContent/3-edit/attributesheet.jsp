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
	<form id="form1" action="<%=request.getContextPath()%>/AttributeSheetServlet" method="post">
		<!-- Contents Main -->
		<div class="column-contents">
			<!-- Contents Right -->
			<div class="column-contents-1">
				<article class="article">
					<!-- タイトル -->
					<h1>ExcelCreator for Java - JavaEE Sample</h1>
					<h2>
						<i class="fa fa-chevron-right"></i>シート操作
					</h2>
					<p>ExcelCreator の機能でシートの設定や各操作を行います。</p>
					<p>
						<i class="fa fa-square"></i>操作対象シート
					</p>
					<p>操作対象となる Excel シートの切り替えを行います。</p>
					<p>
						<input type="submit" name="sheetattr1" value="Excel ファイル作成" style="width: 150px;" />
					</p>
					<hr />
					<p>
						<i class="fa fa-square"></i>ヘッダー/フッター
					</p>
					<p>ページヘッダー/フッターの設定を行います。</p>
					<p>
						<input type="submit" name="sheetattr2" value="Excel ファイル作成" style="width: 150px;" />
					</p>
					<hr />
					<p>
						<i class="fa fa-square"></i>シート名、ページ設定（ページタブ）、グリッド線（枠線）
					</p>
					<p>シート名、ページ設定（ページタブ）、グリッド線（枠線）の設定を行います。</p>
					<p>
						<input type="submit" name="sheetattr3" value="Excel ファイル作成" style="width: 150px;" />
					</p>
					<hr />
					<p>
						<i class="fa fa-square"></i>印刷タイトル、ページ方向、印刷範囲
					</p>
					<p>印刷タイトル（行/列）、ページ方向、印刷範囲の設定を行います。</p>
					<p>
						<input type="submit" name="sheetattr4" value="Excel ファイル作成" style="width: 150px;" />
					</p>
					<hr />
					<p>
						<i class="fa fa-square"></i>シート追加
					</p>
					<p>3 シートの Excel ファイルを新規作成し、末尾に 1 シート追加を行います。</p>
					<p>
						<input type="submit" name="sheetattr5" value="Excel ファイル作成" style="width: 150px;" />
					</p>
					<hr />
					<p>
						<i class="fa fa-square"></i>シート削除
					</p>
					<p>3 シートの Excel ファイルを新規作成し、2 シート目を削除します。</p>
					<p>
						<input type="submit" name="sheetattr6" value="Excel ファイル作成" style="width: 150px;" />
					</p>
					<hr />
					<p>
						<i class="fa fa-square"></i>シートコピー
					</p>
					<p>3 シートの Excel ファイルを新規作成し、1 シート目をコピーして末尾に挿入します。</p>
					<p>
						<input type="submit" name="sheetattr7" value="Excel ファイル作成" style="width: 150px;" />
					</p>
					<hr />
					<p>
						<i class="fa fa-square"></i>アクティブシート
					</p>
					<p>3 シートの Excel ファイルを新規作成し、生成 Excel ファイルオープン時に Sheet3 を表示するよう設定します。</p>
					<p>
						<input type="submit" name="sheetattr8" value="Excel ファイル作成" style="width: 150px;" />
					</p>
					<p class="annotation1">※サンプルコードは「src/servlet/AttributeSheetServlet.java」を参照してください。</p>
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