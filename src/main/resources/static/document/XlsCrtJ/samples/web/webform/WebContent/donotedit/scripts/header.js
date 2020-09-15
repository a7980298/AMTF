function header(rootDir, imgFileName){
    var html = "";

	html += '<div id="header-top"></div>';
	html += '<header class="header">';
	html += '<div class="header-inner">';
	html += '<div class="title">';
	html += '<h1>';
	html += '<img src="{$root}images/{$fileName}" alt="Advance software">';
	html += '</h1>';
	html += '</div>';
	html += '</div>';
	html += '</header>';
    html = html.replace(/\{\$root\}/g, rootDir);
    html = html.replace(/\{\$fileName\}/g, imgFileName);
    document.write(html);
}
