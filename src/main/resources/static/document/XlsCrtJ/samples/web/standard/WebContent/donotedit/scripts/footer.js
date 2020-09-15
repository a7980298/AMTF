function footer(rootDir){
    var html = "";

    html += '<div>';
    html += '<p class="pagetop"><a href="#header-top"><i class="fa fa-chevron-up"></i></a></p>';
    html += '</div>';
    html += '<footer id="footer" class="footer">';
    html += '<div class="footer-inner">';
    html += '</p>';
    html += '<div class="copyright">';
    html += '<p>Copyright (C) 2017 Advance Software Corp. All Rights Reserveded.</p>';
    html += '</div>';
    html += '</div>';
    html += '</footer>';
    html = html.replace(/\{\$root\}/g, rootDir);
    document.write(html);
}
