var gulp = require('gulp'),
    concat = require('gulp-concat');
var plugins = require('gulp-load-plugins')();
var pngquant = require('imagemin-pngquant'); //png图片压缩插件

var paths = {
    script: ['./public/js/commonTools.js','./public/js/modules/*.js','./public/js/controllers/*.js','./public/js/services/*.js','./public/js/directives/*.js','./public/js/filters/*.js']
};

gulp.task('clean', function() {
    return gulp.src('./public/dist/*')
        .pipe(plugins.clean());
});

gulp.task('jsHint', function () {
    return gulp.src(paths.script)
        .pipe(plugins.jshint())
        .pipe(plugins.jshint.reporter()); // 输出检查结果
});
gulp.task('imagemin', function () {
    return gulp.src('./public/images/*.{png,jpg,gif,ico}')
        .pipe(plugins.imagemin({
            progressive: true,
            use: [pngquant()] //使用pngquant来压缩png图片(无损压缩)
        }))
        .pipe(gulp.dest('./public/dist/images/'));
});
gulp.task('concatJS', function () {
    gulp.src(paths.script)
        .pipe(concat('application.js'))
        .pipe(gulp.dest('./public/dist'))

});
gulp.task('minJS', function () {
    gulp.src(paths.script)
        .pipe(concat('application.js'))
        .pipe(gulp.dest('./public/dist'))
        .pipe(plugins.uglify())
        .pipe(plugins.rename({suffix: '.min'}))
        .pipe(gulp.dest('./public/dist/'))

});
gulp.task('concatCSS', function () {
    gulp.src(['./public/css/AdminLTE.css','./public/css/common.css'])
        .pipe(concat('application.css'))//合并后的文件名
        .pipe(gulp.dest('./public/dist'))

});
gulp.task('minCSS', function () {
    gulp.src(['./public/css/AdminLTE.css','./public/css/common.css'])
        .pipe(concat('application.css'))//合并后的文件名
        .pipe(gulp.dest('./public/dist'))
        .pipe(plugins.minifyCss())
        .pipe(plugins.rename({suffix: '.min'}))
        .pipe(plugins.concat('application.min.css'))
        .pipe(gulp.dest('./public/dist/'));
});
gulp.task('minifyHtml', function () {
    return gulp.src(['./tpls/*.html','./tpls/common/*.html','./tpls/directives/*.html'])
        .pipe(plugins.minifyHtml())
        .pipe(gulp.dest('./public/dist/tpls'))

});
gulp.task('minifyHtmlCommon', function () {
    return gulp.src('./tpls/common/*.html')
        .pipe(plugins.minifyHtml())
        .pipe(gulp.dest('./public/dist/tpls/common'))

});
gulp.task('minifyHtmlDirectives', function () {
    return gulp.src('./tpls/directives/*.html')
        .pipe(plugins.minifyHtml())
        .pipe(gulp.dest('./public/dist/tpls/directives'))

});

gulp.task('watch', function () {
    gulp.watch(paths.script, ['concatJS']);
    gulp.watch('./public/css/*.css', ['concatCSS']);

    //gulp.watch('./public/dist/application.css', ['minifyCss']);
});

gulp.task('dev', ['clean','watch','concatJS','concatCSS']);
gulp.task('pro', ['clean','imagemin','minifyHtml','minifyHtmlCommon','minifyHtmlDirectives','minJS','minCSS']);

gulp.task('default', function () {
    return gulp.start('dev');
});