FROM eclipse-temurin:21-jre-jammy

# Install minimal system deps
RUN apt-get update && \
  apt-get install -y --no-install-recommends \
  curl \
  python3 \
  python3-pip \
  ca-certificates && \
  apt-get clean && \
  rm -rf /var/lib/apt/lists/*

# Install Jupyter
RUN pip3 install --no-cache-dir jupyter

# Install coursier + almond (auto-selects latest stable Scala)
RUN curl -fL https://github.com/coursier/launchers/raw/master/cs-x86_64-pc-linux.gz | gzip -d > /usr/local/bin/cs && \
  chmod +x /usr/local/bin/cs && \
  cs install almond --dir /usr/local/bin && \ 
  rm -f /usr/local/bin/cs

# Install kernel
RUN almond --install

# Configure Jupyter
EXPOSE 8888
WORKDIR /notebooks
CMD ["jupyter", "notebook", \
  "--ip=0.0.0.0", \
  "--port=8888", \
  "--NotebookApp.token=''", \
  "--NotebookApp.password=''", \
  "--NotebookApp.disable_check_xsrf=True", \
  "--no-browser", \
  "--allow-root"]