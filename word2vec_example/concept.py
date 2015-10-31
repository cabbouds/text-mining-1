import gensim
import sys


def generate_concept(query1, query2):
	'''
	function: given two words, identify shared "concepts"
	input: string
	output: list of shared concepts
	'''

	# trained w2v using twitter corpus on 3/5/15 

	model = gensim.models.Word2Vec.load('w2v_classifier.pkl')
	concepts = model.most_similar(positive=[query1, query2])
	return concepts

def main():
	scriptname, query1, query2 = sys.argv
	similar_concepts = generate_concept(query1, query2)
	for concepts in similar_concepts:
		print concepts

if __name__ == '__main__':
    main()