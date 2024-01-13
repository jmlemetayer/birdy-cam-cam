SUMMARY = "Systemd services for Birdy Cam Cam"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = " \
    file://birdycamcam-altroot.service \
    file://birdycamcam-growfs.service \
    file://birdycamcam-repart.service \
    file://configure-altroot-alias.sh \
    file://create-altroot-partition.sh \
    file://grow-root-partition.sh \
"

inherit systemd

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install() {
    for SCRIPT in ${WORKDIR}/*.sh
    do
        install -Dm 755 ${SCRIPT} ${D}${libexecdir}/birdycamcam/${SCRIPT##*/}
    done

    for SERVICE in ${WORKDIR}/*.service
    do
        install -Dm 644 ${SERVICE} ${D}${systemd_system_unitdir}/${SERVICE##*/}
        sed -i "s:@LIBEXECDIR@:${libexecdir}:g" ${D}${systemd_system_unitdir}/${SERVICE##*/}
    done
}

SYSTEMD_SERVICE:${PN} = " \
    birdycamcam-repart.service \
    birdycamcam-growfs.service \
    birdycamcam-altroot.service \
"

FILES:${PN} = " \
    ${libexecdir}/birdycamcam \
    ${systemd_system_unitdir} \
"
