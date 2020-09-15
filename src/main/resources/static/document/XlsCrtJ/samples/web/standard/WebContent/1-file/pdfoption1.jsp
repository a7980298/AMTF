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
	<form id="form1" action="<%=request.getContextPath()%>/PdfOption1Servlet" method="post">
		<!-- Contents Main -->
		<div class="column-contents">
			<!-- Contents Right -->
			<div class="column-contents-1">
				<article class="article">
					<!-- タイトル -->
					<h1>ExcelCreator for Java - JavaEE Sample</h1>
					<h2>
						<i class="fa fa-chevron-right"></i>ファイル作成（PDF オプション 1）
					</h2>
					<p>出力 PDF ファイルの暗号化、文書のプロパティの設定を行います。</p>
					<p>
						<i class="fa fa-square"></i>PDF ファイルの暗号化
					</p>
					<p>
						PDF ファイルにパスワードの設定を行います。<br />
						暗号化強度が(NoPassword)以外でも、オーナーとユーザーパスワードが未設定であればパスワードなしで生成されます。
					</p>
					<p>
					<label style="margin-right: 15px">暗号化強度</label>
					<select name="encryptiontype" size="1">
						<option value="0">NoPassword</option>
						<option value="1">Acrobat3_RC4_40</option>
						<option value="2">Acrobat5_RC4_128</option>
						<option value="3">Acrobat6_RC4_128</option>
					</select>
					</p>
					<p>
						<label style="margin-right: 15px">オーナーパスワード</label><input type="text" name="ownerpassword" size="20" style="width: 100px" value="Owner.1" />
					</p>
					<p>
						<label style="margin-right: 15px">ユーザーパスワード</label><input type="text" name="userpassword" size="20" style="width: 100px" value="User.1" />
					</p>
					<p>ユーザーパスワードの権限（チェック ON の制限を許可します。）</p>
					<div style="padding: 0px 0px 0px 25px; font-size: 14px;">
						<div style="display: block; clear: both;">
							<div style="float: left; width: 250px;"><input type="checkbox" name="print" id="c1" value="print" checked="checked" /><label for="c1">Print</label></div>
							<div style="float: left; width: 200px;"><input type="checkbox" name="change" id="c2" value="change" checked="checked" /><label for="c2">Change</label></div>
						</div>
						<div style="display: block; clear: both;">
							<div style="float: left; width: 250px;"><input type="checkbox" name="copy" id="c3" value="copy" checked="checked" /><label for="c3">Copy</label></div>
							<div style="float: left; width: 200px;"><input type="checkbox" name="comment" id="c4" value="comment" checked="checked" /><label for="c4">Comment</label></div>
						</div>
						<div style="display: block; clear: both;">
							<div style="float: left; width: 250px;"><input type="checkbox" name="formfield" id="c5" value="formfield" checked="checked" /><label for="c5">FormField</label></div>
							<div style="float: left; width: 200px;"><input type="checkbox" name="contentaccess" id="c6" value="contentaccess" checked="checked" /><label for="c6">ContentAccess</label></div>
						</div>
						<div style="display: block; clear: both;">
							<div style="float: left; width: 250px;"><input type="checkbox" name="documentassembly" id="c7" value="documentassembly" checked="checked" /><label for="c7">DocumentAssembly</label></div>
							<div style="float: left; width: 200px;"><input type="checkbox" name="printhigh" id="c8" value="printhigh" checked="checked" /><label for="c8">PrintHigh</label></div>
						</div>
					</div>
					<div style="clear: both;"></div>
					<br />
					<p>
						<input type="submit" name="pdfencryption" value="PDF ファイル作成" style="width: 150px;" />
					</p>
					<hr />
					<p>
						<i class="fa fa-square"></i>PDF 文書のプロパティ
					</p>
					<p><label style="display:inline-block;width:130px;">タイトル</label><input type="text" name="title" size="20" style="width: 60%" value="PDF Title" /></p>
					<p><label style="display:inline-block;width:130px;">サブタイトル</label><input type="text" name="subtitle" size="20" style="width: 60%" value="PDF SubTitle" /></p>
					<p><label style="display:inline-block;width:130px;">作成者</label><input type="text" name="author" size="20" style="width: 60%" value="PDF Author" /></p>
					<p><label style="display:inline-block;width:130px;">アプリケーション</label><input type="text" name="application" size="20" style="width: 60%" value="ExcelCreator for Java Sample Application" /></p>
					<p><label style="display:inline-block;width:130px;">PDF 変換</label><input type="text" name="producer" size="20" style="width: 60%" value="PDF Producer" /></p>
					<p>
						<input type="submit" name="pdfproperty" value="PDF ファイル作成" style="width: 150px;" />
					</p>

					<p class="annotation1">※サンプルコードは「src/servlet/PdfOption1Servlet.java」を参照してください。</p>
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