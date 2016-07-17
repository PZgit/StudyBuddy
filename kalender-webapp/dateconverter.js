function convertDateForm(ms) {
    var date = new Date(parseInt(ms));
    document.dateform.dateLong.value = date;
    document.dateform.clicky.value = "shit converted";
    document.dateform.clicky.disabled = true;
}

function showDate() {
    var iso = new Date();
    document.currentDateForm.dateMs.value = iso.getTime();
    document.currentDateForm.dateIso.value = iso;

    var sdate = iso.getDate();
    var date0 = (sdate < 10) ? "0" : "";

    var smonth = iso.getMonth() + 1;
    var month0 = (smonth < 10) ? "0": "";

    var de = date0 + sdate + "." + month0 + smonth + "." + iso.getFullYear();
    document.currentDateForm.dateDe.value = de;

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
    document.currentDateForm.dateLong.value = text;

    var shours = iso.getHours();
    var hours0 = (shours < 10) ? "0": "";
    var sminutes = iso.getMinutes();
    var minutes0 = (sminutes < 10) ? "0": "";

    var epic = text + ", " + hours0 + shours + ":" + minutes0 + sminutes + " Uhr";
    document.currentDateForm.dateEpic.value = epic;
}
