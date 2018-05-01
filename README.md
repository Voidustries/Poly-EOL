<p align="center">
  <a href="https://voidustries.github.io/Poly_Project/" target="_blank" rel="noopener noreferrer">
    <img width="200" src="https://github.com/Voidustries/Poly/blob/master/src/main/resources/Icon.png" alt="Poly logo">
  </a>
</p>

<h1 align="center">Poly</h1>

<p align="center">
  <a href="https://www.codacy.com/app/ponimansky.guy/Poly?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Voidustries/Poly&amp;utm_campaign=Badge_Grade">
    <img src="https://img.shields.io/codacy/grade/0330000d284043f19a126cada035d410.svg?style=flat-square" alt="Codacy grade">
  </a>
  <a href="https://circleci.com/gh/Voidustries/Poly/">
    <img src="https://img.shields.io/circleci/project/github/Voidustries/Poly/feature%2Ftvdb-client.svg?style=flat-square" alt="CircleCI">
  </a>
  <a href="https://github.com/Voidustries/Poly/issues">
    <img src="https://img.shields.io/github/issues-raw/voidustries/poly.svg?style=flat-square" alt="Github Issues">
  </a>
  <a href="https://github.com/Voidustries/Poly/issues">
    <img src="https://img.shields.io/github/issues-closed-raw/voidustries/poly.svg?style=flat-square" alt="Github Closed Issues">
  </a>
  <a href="https://github.com/Voidustries/Poly/pulls">
    <img src="https://img.shields.io/github/issues-pr-raw/voidustries/poly.svg?style=flat-square" alt="Github Pull Requests">
  </a>
  <a href="https://github.com/Voidustries/Poly/pulls">
    <img src="https://img.shields.io/github/issues-pr-closed-raw/voidustries/poly.svg?style=flat-square" alt="Github Closed Pull Requests">
  </a>
  <a href="https://github.com/Voidustries/Poly/graphs/contributors">
    <img src="https://img.shields.io/github/contributors/voidustries/poly.svg?style=flat-square" alt="Github Contributors">
  </a>
  <a href="https://github.com/Voidustries/Poly/blob/master/LICENSE">
    <img src="https://img.shields.io/github/license/voidustries/poly.svg?style=flat-square" alt="License">
  </a>
  <a href="https://github.com/Voidustries/Poly">
    <img src="https://img.shields.io/github/repo-size/voidustries/poly.svg?style=flat-square" alt="Github Repo Size">
  </a>
</p>

Poly is a management utility to help organise a database of TV shows and movies. Handling large amounts of files in a
library can be daunting and unruly, Poly helps by doing most of the work for you so you have more time to watch and 
spend less time tracking, renaming, and downloading. The hierarchy that Poly follows is the same as Plex, as this is the 
most popular home media server.   

[![Demo](http://thumbs.gfycat.com/TornFoolishAlbino-size_restricted.gif)](https://gfycat.com/gifs/detail/TornFoolishAlbino)

## Directory Hierarchy


##### Outline
```
+---Movies
|   |   *Movie Name* (*Year*).*ext*
|   |   *Movie Name* (*Year*).*ext*
\---TV Shows
    +---*Show Name*
    |   +---*Season*
    |   |      *Show Name* - *S00E00* - *Episode Name*.*ext*
```

##### Example
```
+---Movies
|   |   The Lord of the Rings The Fellowship of the Ring (2001).mp4
|   |   The Lord of the Rings The Return of the King (2003).mp4
|   |   The Lord of the Rings The Two Towers (2002).mp4
|   |   The Martian (2015).mkv
\---TV Shows
    +---Mr. Robot
    |   +---Season 1
    |   |       Mr. Robot - S01E01 - eps1.0_hellofriend.mov.mkv
    |   |       Mr. Robot - S01E02 - eps1.1_ones-and-zer0es.mpeg.mkv
    |   |       Mr. Robot - S01E03 - eps1.2_d3bug.mkv.mkv
```

## Contributing

1. Fork it!
2. Create your feature branch: `git checkout -b my-new-feature`
3. Commit your changes: `git commit -am 'Add some feature'`
4. Push to the branch: `git push origin my-new-feature`
5. Submit a pull request! :smile:

## History
None as of yet


## Future Plans

- [ ] Add TV Shows from Mobile App AND/OR Desktop App.
- [ ] Allow Poly to directly download through interface rather than a external program.
- [ ] Sync with TheTVDB for Show renaming.
- [ ] Sync with TheTVDB for meta data.
- [ ] Full Code Coverage with Junit5 tests
- [ ] Database Rearrangement
- [ ] Show Tracking

## Credits

* [Stone Monarch](https://github.com/StoneMonarch)
* [Guy Ponimansky](https://github.com/gponimansky)
