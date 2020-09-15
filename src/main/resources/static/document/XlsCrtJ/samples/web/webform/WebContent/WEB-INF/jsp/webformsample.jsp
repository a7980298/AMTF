<%@page import="model.SampleWork"%>
<%@page import="com.sun.media.sound.ModelAbstractChannelMixer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>ExcelCreator for Java - Web サンプル (WebForm)</title>
<meta name="viewport" content="width=device-width">
<meta name="author" content="アドバンスソフトウェア株式会社">
<meta name="copyright" content="アドバンスソフトウェア株式会社">
<link rel="shortcut icon" href="<%=request.getContextPath()%>/donotedit/images/ecjava_sampleicon.ico" type="image/vnd.microsoft.icon">
<!--[if lt IE 9]>
	<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
<!--
	<link rel="stylesheet" href="<%=request.getContextPath()%>/donotedit/css/style.css">
-->
<link rel="stylesheet" href="<%=request.getContextPath()%>/donotedit/css/style.css">

<link rel="stylesheet" href="<%=request.getContextPath()%>/donotedit/font-awesome-4.3.0/css/font-awesome.min.css">
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<!-- jQuery UI -->
<link type="text/css" href="<%=request.getContextPath()%>/donotedit/scripts/jquery-ui.css" rel="stylesheet">
<script type="text/javascript" src="<%=request.getContextPath()%>/donotedit/scripts/jquery-ui.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/donotedit/scripts/footerFixed.js"></script>
<!-- ヘッダ、フッタ共通化 -->
<script type="text/javascript" src="<%=request.getContextPath()%>/donotedit/scripts/header.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/donotedit/scripts/footer.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/donotedit/scripts/footerfixed.js"></script>
</head>
<body>
	<script type="text/javascript">
		header("<%=request.getContextPath()%>/donotedit/", "ecjava_sampleheader.png");
	</script>
	<form name="form1" id="form1" action="WebFormSample" method="post">
		<!-- Contents Main -->
		<div class="column-contents">
			<article class="article">
				<!-- タイトル -->
				<h1>ExcelCreator for Java - Web サンプル (WebForm)</h1>
				<p>フォームで入力したデータを基に合計請求書の Excel ファイルを作成する Web サンプルです。</p>
				<table class="tile">
					<tbody>
						<tr>
							<th width="180" class="r1">請求先</th>
							<td class="rt2"><input name="textBoxName" id="textBoxName" style="width: 400px;" type="text" value="○○株式会社"></td>
						</tr>
						<tr>
							<th class="r1">郵便番号/住所</th>
							<td class="r2"><input name="textBoxPost" id="textBoxPost" style="width: 80px;" type="text" value="1000000"><br /> <input name="textBoxAddress" id="textBoxAddress" style="width: 400px;" type="text" value="東京都○○区△△1-2-3 □□ビル3F"></td>
						</tr>
						<tr>
							<th class="r1">前回請求額</th>
							<td class="r2"><input name="textBoxSeikyu" id="textBoxSeikyu" style="width: 150px;" type="text" value="500000"></td>
						</tr>
						<tr>
							<th class="r1">売上額</th>
							<td class="r2"><input name="textBoxUriage" id="textBoxUriage" style="width: 150px;" type="text" value="1200000"></td>
						</tr>
						<tr>
							<th class="r1">入金額</th>
							<td class="r2"><input name="textBoxNyukin" id="textBoxNyukin" style="width: 150px;" type="text" value="1000000"></td>
						</tr>
					</TBODY>
				</table>
				<p>
					<span class="annotation1">※ファイルはサーバーの[<%=model.SampleWork.getFileOutputDirectory()%>]に生成されます。</span><br />
					<span class="annotation1">Javaバージョン：<%=System.getProperty("java.version")%></span>
				</p>
				<input name="ButtonCreateFile" id="ButtonCreateFile" style="width: 150px; height: 30px; font-family: Meiryo, serif;" onclick="document.getElementById('LabelTextError').innerText = ''; false;" type="submit" value="合計請求書の作成">&nbsp;<SPAN id="LabelTextError" style="color: red;"></SPAN>
			</article>
		</div>
		<!-- フッタ -->

		<script type="text/javascript">
			footer();
		</script>
	</form>
</body>
</html>

