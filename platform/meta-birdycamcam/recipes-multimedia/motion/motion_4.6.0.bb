SUMMARY = "Motion, a software motion detector"
HOMEPAGE = "https://motion-project.github.io"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRC_URI = "https://github.com/Motion-Project/${BPN}/archive/refs/tags/release-${PV}.tar.gz"
SRC_URI[sha256sum] = "9268df31a5ebeaf8daca4747cdcd01c86e223625b6f971e9bcec98edf35ec06f"

S = "${WORKDIR}/${BPN}-release-${PV}"

inherit autotools gettext pkgconfig

DEPENDS = " \
    jpeg \
    libmicrohttpd \
"

EXTRA_OECONF = " \
    --without-mysql \
    KILL=${bindir}/kill \
"

PACKAGECONFIG ??= " \
    ${@bb.utils.contains('MACHINE_FEATURES', 'vc4graphics', '', 'mmal', d)} \
    webp ffmpeg \
"

PACKAGECONFIG[webp] = "--with-webp,--without-webp"
PACKAGECONFIG[mmal] = "--with-mmal,--without-mmal,userland"
PACKAGECONFIG[ffmpeg] = "--with-ffmpeg,--without-ffmpeg,ffmpeg"
PACKAGECONFIG[mariadb] = "--with-mariadb,--without-mariadb,mariadb"
PACKAGECONFIG[postgresql] = "--with-pgsql,--without-pgsql,postgresql"
PACKAGECONFIG[sqlite3] = "--with-sqlite3,--without-sqlite3,sqlite3"
