function convertDate(din, dformat) {
    var iso = new Date(parseInt(din));
    // console.log('content Date(ms)' + iso);
    if (dformat == 1) return iso.getTime();
    if (dformat == 2) return iso;

    var sdate = iso.getDate();
    var date0 = (sdate < 10) ? "0" : "";

    var smonth = iso.getMonth() + 1;
    var month0 = (smonth < 10) ? "0": "";

    var de = date0 + sdate + "." + month0 + smonth + "." + iso.getFullYear();
    if (dformat == 3) return de;

    var day = new Array();
    day[0] = "Sonntag";
    day[1] = "Montag";
    day[2] = "Dienstag";
    day[3] = "Mittwoch";
    day[4] = "Donnerstag";
    day[5] = "Freitag";
    day[6] = "Samstag";
    var sday = day[iso.getDay()];

    var tmonth = new Array();
    tmonth[0]="Januar";
    tmonth[1]="Februar";
    tmonth[2]="März";
    tmonth[3]="April";
    tmonth[4]="Mai";
    tmonth[5]="Juni";
    tmonth[6]="Juli";
    tmonth[7]="August";
    tmonth[8]="September";
    tmonth[9]="October";
    tmonth[10]="November";
    tmonth[11]="Dezember";
    var lmonth = tmonth[iso.getMonth()];

    var text = sday + ", " + date0 + sdate + ". " + lmonth + " " + iso.getFullYear();
    if (dformat == 4) return text;

    var shours = iso.getHours();
    var hours0 = (shours < 10) ? "0": "";
    var sminutes = iso.getMinutes();
    var minutes0 = (sminutes < 10) ? "0": "";

    var epic = text + ", " + hours0 + shours + ":" + minutes0 + sminutes + " Uhr";
    if (dformat == 5) return epic;

    var dataTableFormat = hours0 + shours + ":" + minutes0 + sminutes + " Uhr";
    if (dformat == 6) return dataTableFormat;

    var sortable = iso.getFullYear() + "/" + month0 + smonth + "/" + date0 + sdate + ", " + hours0 + shours + ":" + minutes0 + sminutes;
    if (dformat == 7) return sortable;

    var timeonly = hours0 + shours + ":" + minutes0 + sminutes;
    if (dformat == 8) return timeonly;
}