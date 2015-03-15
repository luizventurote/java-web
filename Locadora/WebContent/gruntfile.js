// This shows a full config file!
module.exports = function (grunt) {

    // IP
    var ip_project = "127.0.0.1";

    // Js Libs
    var bootstrap = 'build/js/lib/bootstrap.min.js';
    var jquery = 'build/js/lib/jquery.min.js';

    // CSS Libs
    var bootstrap_css = 'build/css/bootstrap.min.css';
    var font_awesome_css = 'build/css/font-awesome.min.css'

    // Main JS
    var mainjs = 'build/js/main.js';
  
    grunt.initConfig({

        // Read package json
        pkg: grunt.file.readJSON('package.json'),

        watch: {
            
          build: {
            files: ['**/*.js', '**/*.scss', '**/*.html', '**/*.php'],
            tasks: ['concat', 'uglify', 'sass', 'concat:css', 'cssmin'],
            options: {
              spawn: false,
            },
          },

          struct: {
            files: ['**/*.html', '**/*.php'],
            options: {
              spawn: false,
            },
          },

          sass: {
            files: ['**/*.scss', '**/*.html', '**/*.php'],
            tasks: ['sass', 'concat:css', 'cssmin'],
            options: {
              spawn: false,
            },
          },

          js: {
            files: ['**/*.js', '**/*.html', '**/*.php'],
            tasks: ['concat', 'uglify'],
            options: {
              spawn: false,
            },
          },

        }, // watch

        sass: {                            
          dist: {               
            options: {                    
              style: 'expanded'
            },
            files: {                  
              'css/cache-style.css': 'build/scss/style.scss'
            }
          }
        }, // sass

        concat: {
          options: {
            separator: '\n\n\n'
          },
          js: {
            src: [jquery, bootstrap, mainjs],
            dest: 'js/main.js'
          },
          css: {
            src: [bootstrap_css, font_awesome_css, 'css/cache-style.css'],
            dest: 'css/style.css'
          }
        }, // concat

        uglify: {
          options: {
            banner: '/*! Want to know more about it? Access the file js/main.js ;) */\n'
          },
          build: {
            src: 'js/main.js',
            dest: 'js/main.min.js'
          }
        }, // uglify

        cssmin: {
          add_banner: {
            options: {
              banner: '/* Want to know more about it? Access the file css/style.css ;) */'
            },
            files: {
              'css/style.min.css': ['css/style.css']
            }
          }
        }, // cssmin

        clean: {
          // Deletes files generated in the project construction
          project: {
            src: ['js/main.js', 'js/main.min.js', 'css/style.css', 'css/style.min.css']
          },
          // Deletes css files generated in the project construction
          sass: {
            src: ['css/cache-style.css', '.sass-cache']
          }
        }, // clean

        copy: {
          main: {
            src: 'src/*',
            dest: 'dest/',
          },
        }, // copy
        
        browser_sync: {
            dev: {
                files: {
                    src : [
                        'css/*.css',
                        'img/**/*.jpg',
                        'img/**/*.png',
                        'js/**/*.js',
                        '**/*.php',
                        '**/*.html'
                    ]
                },
                options: {

                  // Definindo um IP manualmente
                  host : ip_project,

                  // Intervalo das portas
                  ports: {
                      min: 3000,
                      max: 3002
                  },

                  // Atribuíndo um diretório base
                  server: {
                      baseDir: "."
                  },

                  // Recarrega quando o css é alterado
                  injectChanges: false,

                  // Integrando com a tarefa "watch"
                  watchTask: true,

                  // Sincronizando os eventos entre os dispositívos
                  ghostMode: {
                      clicks: true,
                      scroll: true,
                      links: true,
                      forms: true
                  }
                },
            }
        }
    });

    // load npm tasks
    grunt.loadNpmTasks('grunt-contrib-uglify');
    grunt.loadNpmTasks('grunt-contrib-concat');
    grunt.loadNpmTasks('grunt-contrib-cssmin');
    grunt.loadNpmTasks('grunt-contrib-clean');
    grunt.loadNpmTasks('grunt-contrib-copy');
    grunt.loadNpmTasks('grunt-contrib-sass');
    grunt.loadNpmTasks('grunt-contrib-watch');
    grunt.loadNpmTasks('grunt-browser-sync');

    // create custom task-list
    grunt.registerTask('default', ["concat", "uglify", "sass", "concat:css", "cssmin", "clean:sass"]);
    grunt.registerTask('wdev', ["browser_sync", "watch:build"]);
    grunt.registerTask('wstruct', ["browser_sync", "watch:struct"]);
    grunt.registerTask('wsass', ["browser_sync", "watch:sass"]);
    grunt.registerTask('wjs', ["browser_sync", "watch:js"]);
};