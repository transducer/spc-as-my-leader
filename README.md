# SPC as my leader - programming Clojure with Spacemacs
_Talk for Amsterdam Emacs User Group 30 October 2019_

## Installation

    curl -sL https://deb.nodesource.com/setup_12.x | bash -
    sudo apt-get install -y openjdk-8-jdk leiningen nodejs
    npm install -g shadow-cljs

## Development Mode

### Run application:

    lein clean
    npm install
    lein dev

shadow-cljs will automatically push cljs changes to the browser.

Wait a bit, then browse to [http://localhost:8280](http://localhost:8280).

### Start Cider from Emacs:

Refer to the [shadow-cljs Emacs / CIDER documentation](https://shadow-cljs.github.io/docs/UsersGuide.html#cider).
